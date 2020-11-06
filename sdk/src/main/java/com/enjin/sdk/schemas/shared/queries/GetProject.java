package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for getting a application on the platform.
 *
 * @see com.enjin.sdk.models.Project
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public final class GetProject extends GraphQLRequest<GetProject> {

    /**
     * Sole constructor.
     */
    public GetProject() {
        super("enjin.sdk.shared.GetProject");
    }

    /**
     * Sets the application ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public GetProject id(Integer id) {
        return set("id", id);
    }

    /**
     * Sets the application name.
     *
     * @param name the name
     * @return this request for chaining
     */
    public GetProject name(String name) {
        return set("name", name);
    }

}