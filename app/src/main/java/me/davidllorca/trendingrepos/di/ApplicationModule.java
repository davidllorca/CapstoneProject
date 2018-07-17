package me.davidllorca.trendingrepos.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import me.davidllorca.trendingrepos.data.model.ContributorEntry;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Context provideApplicationContext() { return application; }


}
