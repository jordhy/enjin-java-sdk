package com.enjin.coin.sdk.mockServer;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.service.EnjinService;
import com.enjin.coin.sdk.service.IdentitiesService;
import com.enjin.coin.sdk.vo.identity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class IdentitiesServiceTestsAgainstMockServer extends BaseMockServer {

    private IdentitiesService identities;

    @Before
    public void init() {
        EnjinConfig enjinConfig = new EnjinConfig();
        enjinConfig.setTrustedPlatformUrl(getURL());
        enjinConfig.setInTestMode(true);
        EnjinService enjinService = new EnjinService(enjinConfig);
        identities = enjinService.getIdentitiesService();
    }

    @Test
    public void testGetIdentity() {

        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");

        GetIdentityRequestVO getIdentityRequestVO = ImmutableGetIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentity(identityMap)
                .build();
        assertNotNull(getIdentityRequestVO.toString());

        GetIdentityResponseVO getIdentityResponseVO = identities.getIdentity(getIdentityRequestVO);
        assertNotNull(getIdentityResponseVO);
        assertNotNull(getIdentityResponseVO.toString());
        assertNotNull(getIdentityResponseVO.getIdentityId());
        assertNotNull(getIdentityResponseVO.getPlayerName());
        assertNotNull(getIdentityResponseVO.getEthereumAddress());
        assertNotNull(getIdentityResponseVO.getUuid());
    }

    @Test
    public void testListIdentities() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");


        String afterIdentityId = "after-1";
        String limit = "limit1";
        boolean linked = false;
        ListIdentitiesRequestVO listIdentitiesRequestVO = ImmutableListIdentitiesRequestVO.builder()
                .setAfterIdentityId(afterIdentityId)
                .setAuth("xxzcxcxz")
                .setLimit(limit)
                .setLinked(linked)
                .setIdentity(identityMap)
                .build();
        assertNotNull(listIdentitiesRequestVO.toString());

        ListIdentitiesResponseVO[] listIdentitiesResponseVOArray = identities.listIdentities(listIdentitiesRequestVO);

        for (ListIdentitiesResponseVO listIdentitiesResponseVO : listIdentitiesResponseVOArray) {
            assertNotNull(listIdentitiesResponseVO);
            assertNotNull(listIdentitiesResponseVO.toString());
            assertNotNull(listIdentitiesResponseVO.getIdentityId());
            assertNotNull(listIdentitiesResponseVO.getPlayerName());
            assertNotNull(listIdentitiesResponseVO.getEthereumAddress());
        }
    }

    @Test
    public void testCreateIdentity() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");

        //Test the create identity request
        CreateIdentityRequestVO createIdentityRequestVO = ImmutableCreateIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentity(identityMap)
                .build();
        assertNotNull(createIdentityRequestVO.toString());

        CreateIdentityResponseVO createIdentityResponseVO = identities.createIdentity(createIdentityRequestVO);
        assertNotNull(createIdentityResponseVO);
        assertNotNull(createIdentityResponseVO.toString());
        assertNotNull(createIdentityResponseVO.getIdentityId());
        assertNotNull(createIdentityResponseVO.getIdentityCode());
    }

    @Test
    public void testUpdateIdentity() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");

        Map<String, Object> updateMap = new HashMap<>();
        updateMap.put("player_name", null);
        updateMap.put("ethereum_address", "0x1111111111111111111111111111111111111111");

        UpdateIdentityRequestVO updateIdentityRequestVO = ImmutableUpdateIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentity(identityMap)
                .setUpdate(updateMap)
                .build();
        assertNotNull(updateIdentityRequestVO.toString());

        UpdateIdentityResponseVO updateIdentityResponseVO = identities.updateIdentity(updateIdentityRequestVO);
        assertNotNull(updateIdentityResponseVO);
        assertNotNull(updateIdentityResponseVO.toString());
        assertNotNull(updateIdentityResponseVO.getIdentityMap());
        assertNotNull(updateIdentityResponseVO.getIdentityMap().get("identity_id"));
        assertNotNull(updateIdentityResponseVO.getIdentityMap().get("ethereum_address"));
        assertNotNull(updateIdentityResponseVO.getIdentityMap().get("uuid"));
    }

    @Test
    public void testDeleteIdentity() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");

        // Test the delete identity request
        DeleteIdentityRequestVO deleteIdentityRequestVO = ImmutableDeleteIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentity(identityMap)
                .build();
        assertNotNull(deleteIdentityRequestVO.toString());

        DeleteIdentityResponseVO deleteIdentityResponseVO = identities.deleteIdentity(deleteIdentityRequestVO);
        assertNotNull(deleteIdentityResponseVO);
        assertNotNull(deleteIdentityResponseVO.toString());
        assertNotNull(deleteIdentityResponseVO.getResult());

    }
}
