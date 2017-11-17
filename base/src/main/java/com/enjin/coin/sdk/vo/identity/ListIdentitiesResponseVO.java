package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>List Identities Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class ListIdentitiesResponseVO {

    /**
     * Method to get the identityId.
     * @return Optional<String>
     */
    @SerializedName("identity_id")
    public abstract Optional<String> getIdentityId();

    /**
     * Method to get the ethereumAddress.
     * @return Optional<String>
     */
    @SerializedName("ethereum_address")
    public abstract Optional<String> getEthereumAddress();

    /**
     * Method to get the playerName.
     * @return Optional<String>
     */
    @SerializedName("player_name")
    public abstract Optional<String> getPlayerName();

    /**
     * Class toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "ListIdentitiesResponseVO [identityId=" + getIdentityId().orElse(null) + ", ethereumAddress=" + getEthereumAddress().orElse(null)
                + ", playerName=" + getPlayerName().orElse(null) + "]";
    }

}
