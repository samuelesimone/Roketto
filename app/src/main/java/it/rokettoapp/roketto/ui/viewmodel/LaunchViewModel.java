package it.rokettoapp.roketto.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import it.rokettoapp.roketto.model.Launch;
import it.rokettoapp.roketto.model.ResponseList;
import it.rokettoapp.roketto.repository.LaunchRepository;

public class LaunchViewModel extends AndroidViewModel {

    private final LaunchRepository mLaunchRepository;
    private MutableLiveData<ResponseList<Launch>> mLaunchListLivedata;

    public LaunchViewModel(@NonNull Application application) {

        super(application);
        mLaunchRepository = new LaunchRepository(application);
        mLaunchListLivedata = mLaunchRepository.getLiveData();
    }

    public MutableLiveData<ResponseList<Launch>> getLiveData() {

        return mLaunchListLivedata;
    }

    public void getLaunches(Boolean isConnected) {

        mLaunchRepository.getLaunchList(isConnected);
    }

    public void getLaunchById(String id) {

        mLaunchRepository.getLaunchById(id);
    }

    public void getLaunchesByIds(List<String> ids){
        mLaunchRepository.getLaunchesByIds(ids);
    }
}
