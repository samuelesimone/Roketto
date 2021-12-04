package it.rokettoapp.roketto.repository;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import it.rokettoapp.roketto.database.EventDao;
import it.rokettoapp.roketto.database.RokettoDatabase;
import it.rokettoapp.roketto.model.Event;
import it.rokettoapp.roketto.model.ResponseList;
import it.rokettoapp.roketto.service.EventApiService;
import it.rokettoapp.roketto.util.ServiceLocator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRepository {

    private static final String TAG = "EventRepository";
    private final EventApiService mEventApiService;
    private final EventDao mEventDao;
    private final MutableLiveData<List<Event>> mEventListLiveData;
    int count;

    public EventRepository(Application application) {

        this.mEventApiService = ServiceLocator.getInstance().getEventApiService();
        mEventDao = RokettoDatabase.getDatabase(application).eventDao();
        mEventListLiveData = new MutableLiveData<>();
        count = 0;
    }

    public MutableLiveData<List<Event>> getEventList() {

        getEventsFromApi();
        return mEventListLiveData;
    }

    public void refreshEvents() {

        getEventsFromApi();
    }

    private void getEventsFromApi() {

        Call<ResponseList<Event>> eventResponseCall = mEventApiService.getEvents(5, count);
        eventResponseCall.enqueue(new Callback<ResponseList<Event>>() {

            @Override
            public void onResponse(@NonNull Call<ResponseList<Event>> call,
                                   @NonNull Response<ResponseList<Event>> response) {

                if (response.body() != null && response.isSuccessful()) {
                    List<Event> eventList = response.body().getResults();
                    saveOnDatabase(eventList);
                    Log.d(TAG, "Retrieved " + response.body().getCount() + " events.");
                    mEventListLiveData.postValue(eventList);
                } else {
                    Log.e(TAG, "Request failed.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseList<Event>> call, @NonNull Throwable t) {

                Log.e(TAG, t.getMessage());
            }
        });
        count += 5;
    }

    public void fetchEventById(int id) {

        Call<Event> eventResponseCall = mEventApiService.getEvent(id);
        eventResponseCall.enqueue(new Callback<Event>() {

            @Override
            public void onResponse(@NonNull Call<Event> call,
                                   @NonNull Response<Event> response) {

                if (response.body() != null && response.isSuccessful()) {
                    Event event = response.body();
                    Log.d(TAG, event.getName());
                } else {
                    Log.e(TAG, "Request failed.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Event> call, @NonNull Throwable t) {

                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void fetchPreviousEvents() {

        Call<ResponseList<Event>> eventResponseCall = mEventApiService.getPreviousEvents(5);
        eventResponseCall.enqueue(new Callback<ResponseList<Event>>() {

            @Override
            public void onResponse(@NonNull Call<ResponseList<Event>> call,
                                   @NonNull Response<ResponseList<Event>> response) {

                if (response.body() != null && response.isSuccessful()) {
                    List<Event> eventList = response.body().getResults();
                    StringBuilder debugString = new StringBuilder();
                    for (Event event : eventList) {
                        debugString.append(event.getName()).append(" --- ");
                    }
                    Log.d(TAG, debugString.toString());
                } else {
                    Log.e(TAG, "Request failed.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseList<Event>> call, @NonNull Throwable t) {

                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void fetchPreviousEventById(int id) {

        Call<Event> eventResponseCall = mEventApiService.getPreviousEvent(id);
        eventResponseCall.enqueue(new Callback<Event>() {

            @Override
            public void onResponse(@NonNull Call<Event> call,
                                   @NonNull Response<Event> response) {

                if (response.body() != null && response.isSuccessful()) {
                    Event event = response.body();
                    Log.d(TAG, event.getName());
                } else {
                    Log.e(TAG, "Request failed.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Event> call, @NonNull Throwable t) {

                Log.e(TAG, t.getMessage());
            }
        });
    }
    public void fetchUpcomingEvents() {

        Call<ResponseList<Event>> eventResponseCall = mEventApiService.getUpcomingEvents(5);
        eventResponseCall.enqueue(new Callback<ResponseList<Event>>() {

            @Override
            public void onResponse(@NonNull Call<ResponseList<Event>> call,
                                   @NonNull Response<ResponseList<Event>> response) {

                if (response.body() != null && response.isSuccessful()) {
                    List<Event> eventList = response.body().getResults();
                    StringBuilder debugString = new StringBuilder();
                    for (Event event : eventList) {
                        debugString.append(event.getName()).append(" --- ");
                    }
                    Log.d(TAG, debugString.toString());
                } else {
                    Log.e(TAG, "Request failed.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseList<Event>> call, @NonNull Throwable t) {

                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void fetchUpcomingEventById(int id) {

        Call<Event> eventResponseCall = mEventApiService.getUpcomingEvent(id);
        eventResponseCall.enqueue(new Callback<Event>() {

            @Override
            public void onResponse(@NonNull Call<Event> call,
                                   @NonNull Response<Event> response) {

                if (response.body() != null && response.isSuccessful()) {
                    Event event = response.body();
                    Log.d(TAG, event.getName());
                } else {
                    Log.e(TAG, "Request failed.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Event> call, @NonNull Throwable t) {

                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void saveOnDatabase(List<Event> eventList) {

        RokettoDatabase.databaseWriteExecutor.execute(() -> {
            mEventDao.deleteAll();
            mEventDao.insertEventList(eventList);
        });
    }

    public List<Event> getEventsFromDatabase() {

        List<Event> eventList = new ArrayList<>();
        Runnable runnable = () -> {

            List<Event> results = mEventDao.getAll();
            if (results != null)
                eventList.addAll(results);
        };
        new Thread(runnable).start();
        return eventList;
    }
}
