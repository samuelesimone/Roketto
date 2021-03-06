package it.rokettoapp.roketto.repository;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import it.rokettoapp.roketto.database.AgencyDao;
import it.rokettoapp.roketto.database.RokettoDatabase;
import it.rokettoapp.roketto.model.Agency;
import it.rokettoapp.roketto.model.ResponseList;
import it.rokettoapp.roketto.service.AgencyApiService;
import it.rokettoapp.roketto.util.Constants;
import it.rokettoapp.roketto.util.DatabaseOperations;
import it.rokettoapp.roketto.util.ServiceLocator;
import it.rokettoapp.roketto.util.SharedPreferencesProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgencyRepository {

    private static final String TAG = "AgencyRepository";
    private final AgencyApiService mAgencyApiService;
    private final AgencyDao mAgencyDao;
    private final DatabaseOperations<Integer, Agency> databaseOperations;
    private final MutableLiveData<ResponseList<Agency>> mAgencyListLiveData;
    private final SharedPreferencesProvider mSharedPreferencesProvider;
    int count;

    public AgencyRepository(Application application) {

        this.mAgencyApiService = ServiceLocator.getInstance().getAgencyApiService();
        mSharedPreferencesProvider = new SharedPreferencesProvider(application);
        mAgencyDao = RokettoDatabase.getDatabase(application).agencyDao();
        databaseOperations = new DatabaseOperations<>(mAgencyDao);
        mAgencyListLiveData = new MutableLiveData<>();
        count = 0;
    }

    public MutableLiveData<ResponseList<Agency>> getLiveData() {

        return mAgencyListLiveData;
    }

    public void getAgencyList(Boolean isConnected) {

        if(System.currentTimeMillis()- mSharedPreferencesProvider.getLastUpdate(Constants.SHARED_PREFERENCES_LAST_UPDATE_AGENCY) < Constants.HOUR && isConnected) {
            databaseOperations.getListFromDatabase(mAgencyListLiveData);
        }
        else{
            mSharedPreferencesProvider.setLastUpdate(System.currentTimeMillis(), Constants.SHARED_PREFERENCES_LAST_UPDATE_AGENCY);
            fetchAgencies(0);
        }

    }

    public void getAgencyById(int id) {

        // TODO: Aggiungere un controllo sulla data dell'ultima richiesta alle API
        new Thread(() -> {
            Agency agency = mAgencyDao.getById(id);
            if (agency != null) {
                ResponseList<Agency> responseList = new ResponseList<>();
                List<Agency> agencyList = new ArrayList<>();
                agencyList.add(agency);
                Log.d("dbagency","recupero dati database lancio: " );
                responseList.setResults(agencyList);
                mAgencyListLiveData.postValue(responseList);
            } else
                fetchAgencyById(id);

        }).start();
    }

    public void getNextAgencies(int lastId) {

        new Thread(() -> {
            List<Agency> agencyList = mAgencyDao.getAllInRange(lastId, lastId + 5);
            if (agencyList.size() == 5) {
                ResponseList<Agency> responseList = new ResponseList<>();
                responseList.setResults(agencyList);
                mAgencyListLiveData.postValue(responseList);
            }
            else fetchAgencies(lastId);
        }).start();
    }

    public void refreshAgencies() {

        fetchAgencies(0);
    }

    public void clearAgencies() {

        databaseOperations.deleteAll();
    }

    private void fetchAgencies(int offset) {

        Call<ResponseList<Agency>> agencyResponseCall =
                mAgencyApiService.getAgencies(5, offset, "id");
        agencyResponseCall.enqueue(new Callback<ResponseList<Agency>>() {

            @Override
            public void onResponse(@NonNull Call<ResponseList<Agency>> call,
                                   @NonNull Response<ResponseList<Agency>> response) {

                if (response.body() != null && response.isSuccessful()) {
                    List<Agency> agencyList = response.body().getResults();
                    databaseOperations.saveList(agencyList);
                    mAgencyListLiveData.postValue(response.body());
                    Log.d(TAG, "Retrieved " + agencyList.size() + " agencies.");
                } else {
                    ResponseList<Agency> errorResponse = new ResponseList<>();
                    errorResponse.setError(true);
                    errorResponse.setMessage(response.message());
                    mAgencyListLiveData.postValue(errorResponse);
                    Log.e(TAG, "Request failed.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseList<Agency>> call, @NonNull Throwable t) {

                ResponseList<Agency> errorResponse = new ResponseList<>();
                errorResponse.setError(true);
                errorResponse.setMessage(t.getMessage());
                mAgencyListLiveData.postValue(errorResponse);
                Log.e(TAG, t.getMessage());
            }
        });
        count += 5;
    }

    private void fetchAgencyById(int id) {

        Call<Agency> agencyResponseCall = mAgencyApiService.getAgency(id);
        agencyResponseCall.enqueue(new Callback<Agency>() {

            @Override
            public void onResponse(@NonNull Call<Agency> call,
                                   @NonNull Response<Agency> response) {

                if (response.body() != null && response.isSuccessful()) {
                    Agency agency = response.body();
                    databaseOperations.saveValue(agency);
                    ResponseList<Agency> responseList = new ResponseList<>();
                    List<Agency> agencyList = new ArrayList<>();
                    agencyList.add(agency);
                    responseList.setResults(agencyList);
                    mAgencyListLiveData.postValue(responseList);
                    Log.d(TAG, agency.getName());
                    Log.d("dbagency","recupero dati api lancio: " );
                } else {
                    ResponseList<Agency> errorResponse = new ResponseList<>();
                    errorResponse.setError(true);
                    errorResponse.setMessage(response.message());
                    mAgencyListLiveData.postValue(errorResponse);
                    Log.e(TAG, "Request failed.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Agency> call, @NonNull Throwable t) {

                ResponseList<Agency> errorResponse = new ResponseList<>();
                errorResponse.setError(true);
                errorResponse.setMessage(t.getMessage());
                mAgencyListLiveData.postValue(errorResponse);
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
