package com.enjin.coin.sdk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * <p>Sets up the Gson object.</p>
 */
public final class GsonUtils {

	/** Standard gson element. **/
    public static final Gson GSON;
    /** Gson element with pretty print configured. **/
    public static final Gson GSON_PRETTY_PRINT;

    static {
        GsonBuilder builder = new GsonBuilder();
        GsonUtils.registerAllTypeAdapterFactories(builder);
        GSON = builder.create();

        GsonBuilder builderPrettyPrint = new GsonBuilder();
        GsonUtils.registerAllTypeAdapterFactories(builderPrettyPrint);
        builderPrettyPrint.setPrettyPrinting();
        GSON_PRETTY_PRINT = builderPrettyPrint.create();
    }

    /**
     * Class constructor.
     */
    protected GsonUtils() {
    }

	/**
	 * Method to register all type adapter factories.
	 * 
	 * @param gsonBuilder
	 *            gson builder to configer
	 */
    public static void registerAllTypeAdapterFactories(GsonBuilder gsonBuilder) {
        for (TypeAdapterFactory factory : getAllTypeAdapterFactories()) {
            gsonBuilder.registerTypeAdapterFactory(factory);
        }
    }

    /**
     * Method to get all type adapter factories.
     * @return List<TypeAdapterFactory>
     */
    public static List<TypeAdapterFactory> getAllTypeAdapterFactories() {
        List<TypeAdapterFactory> factories = new ArrayList<>();
        getTypeAdapterFactoryServiceLoader().forEach(factories::add);
        return factories;
    }

    /**
     * Method to get the type adapter factory service loader.
     * @return ServiceLoader<TypeAdapterFactory>
     */
    public static ServiceLoader<TypeAdapterFactory> getTypeAdapterFactoryServiceLoader() {
        return ServiceLoader.load(TypeAdapterFactory.class);
    }

}
