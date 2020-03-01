package com.gmail.eamosse.imdb

import android.app.Application
import com.gmail.eamosse.idbdata.di.dataModule
import com.gmail.eamosse.imdb.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Point d'entrée de l'application
 * C'est la première classe (d'une application Android) qui s'exécute au lancement de l'application
 * Elle peut être considérée comme un singleton, cad il n'existe qu'une instance non nulle de cette classe
 * pendant toute la durée de vie de l'application
 */
class MdbApplication : Application() {

    /**
     * Méthode qui s'exécute à la créatioo de l'application
     * On en profite pour injecter tous les modules Koin
     */
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MdbApplication)
            modules(appModule + dataModule)
        }
    }
}