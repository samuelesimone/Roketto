package it.rokettoapp.roketto.util;

import it.rokettoapp.roketto.service.AgencyApiService;
import it.rokettoapp.roketto.service.ArticleApiService;
import it.rokettoapp.roketto.service.AstronautApiService;
import it.rokettoapp.roketto.service.DockingEventApiService;
import it.rokettoapp.roketto.service.EventApiService;
import it.rokettoapp.roketto.service.ExpeditionApiService;
import it.rokettoapp.roketto.service.LaunchApiService;
import it.rokettoapp.roketto.service.LauncherApiService;
import it.rokettoapp.roketto.service.LocationApiService;
import it.rokettoapp.roketto.service.PadApiService;
import it.rokettoapp.roketto.service.ProgramApiService;
import it.rokettoapp.roketto.service.SFNInfoApiService;
import it.rokettoapp.roketto.service.SpaceStationApiService;
import it.rokettoapp.roketto.service.SpacecraftApiService;
import it.rokettoapp.roketto.service.SpacecraftFlightApiService;
import it.rokettoapp.roketto.service.UpdateApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceLocator {

    private static ServiceLocator sInstance = null;

    private ServiceLocator() { }

    public static ServiceLocator getInstance() {

        if (sInstance == null) {
            synchronized (ServiceLocator.class) {
                sInstance = new ServiceLocator();
            }
        }
        return sInstance;
    }

    public AstronautApiService getAstronautApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(AstronautApiService.class);
    }

    public AgencyApiService getAgencyApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(AgencyApiService.class);
    }

    public SpacecraftApiService getSpacecraftApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(SpacecraftApiService.class);
    }

    public SpacecraftFlightApiService getSpacecraftFlightApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(SpacecraftFlightApiService.class);
    }

    public DockingEventApiService getDockingEventApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(DockingEventApiService.class);
    }

    public PadApiService getPadApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(PadApiService.class);
    }

    public LocationApiService getLocationApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(LocationApiService.class);
    }

    public ProgramApiService getProgramApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(ProgramApiService.class);
    }

    public LauncherApiService getLauncherApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(LauncherApiService.class);
    }

    public LaunchApiService getLaunchApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(LaunchApiService.class);
    }

    public ExpeditionApiService getExpeditionApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(ExpeditionApiService.class);
    }

    public SpaceStationApiService getSpaceStationApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(SpaceStationApiService.class);
    }

    public EventApiService getEventApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(EventApiService.class);
    }

    public UpdateApiService getUpdateApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SD_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(UpdateApiService.class);
    }

    public ArticleApiService getArticleApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SFN_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(ArticleApiService.class);
    }

    public SFNInfoApiService getSFNInfoApiService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.SFN_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(SFNInfoApiService.class);
    }
}
