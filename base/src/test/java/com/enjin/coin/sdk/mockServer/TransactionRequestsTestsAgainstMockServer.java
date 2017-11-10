package com.enjin.coin.sdk.mockServer;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.service.TransactionRequestsService;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsResponseVO;

public class TransactionRequestsTestsAgainstMockServer extends BaseMockServer{

	private TransactionRequestsService transactionRequests;

	@Before
	public void init() {
		transactionRequests = new TransactionRequestsService(getURL(), true);
	}
	
	@Test
	public void testGetTransactionRequest() {		
		GetTransactionRequestRequestVO getTransactionRequestRequestVO = new GetTransactionRequestRequestVO();
		getTransactionRequestRequestVO.setAuth("xxxxxxxx");
		getTransactionRequestRequestVO.setTxrId("123456");
		
		GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequests.getTransactionRequest(getTransactionRequestRequestVO);
		assertNotNull(getTransactionRequestResponseVO);
		assertNotNull(getTransactionRequestResponseVO.getTxrId());
		assertNotNull(getTransactionRequestResponseVO.getIdentityMap());
		assertNotNull(getTransactionRequestResponseVO.getIdentityMap().get("identity_id"));
		assertNotNull(getTransactionRequestResponseVO.getIdentityMap().get("player_name"));
		assertNotNull(getTransactionRequestResponseVO.getIdentityMap().get("ethereum_address"));
		assertNotNull(getTransactionRequestResponseVO.getRecipientMap());
		assertNotNull(getTransactionRequestResponseVO.getRecipientMap());
		assertNotNull(getTransactionRequestResponseVO.getRecipientMap().get("identity_id"));
		assertNotNull(getTransactionRequestResponseVO.getRecipientMap().get("player_name"));
		assertNotNull(getTransactionRequestResponseVO.getRecipientMap().get("ethereum_address"));
		assertNotNull(getTransactionRequestResponseVO.getType());
		assertNotNull(getTransactionRequestResponseVO.getIcon());
		assertNotNull(getTransactionRequestResponseVO.getTitle());
		assertNotNull(getTransactionRequestResponseVO.getValueMap());
		assertNotNull(getTransactionRequestResponseVO.getValueMap().get("ENJ"));
	}

	@Test
	public void testListTransactionRequests() {		
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("identity_id", "12345");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("identity_id", "54321");
		
		ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = new ListTransactionRequestsRequestVO();
		listTransactionRequestsRequestVO.setAuth("xxxxxxxx");
		listTransactionRequestsRequestVO.setIdentityMap(listIdentityMap);
		listTransactionRequestsRequestVO.setAppId("123");
		listTransactionRequestsRequestVO.setRecipientMap(listRecipientMap);
		listTransactionRequestsRequestVO.setType("buy");
		listTransactionRequestsRequestVO.setAfterTxrId("1234567");
		listTransactionRequestsRequestVO.setLimit("50");
		listTransactionRequestsRequestVO.setCurrency("23456");
		
		ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequests.listTransactionRequests(listTransactionRequestsRequestVO);

		for (ListTransactionRequestsResponseVO listTransactionRequestsResponseVO : listTransactionRequestsResponseVOArray) {
			assertNotNull(listTransactionRequestsResponseVO);
			assertNotNull(listTransactionRequestsResponseVO.getTxrId());
			assertNotNull(listTransactionRequestsResponseVO.getIdentityMap());
			assertNotNull(listTransactionRequestsResponseVO.getIdentityMap().get("identity_id"));
			assertNotNull(listTransactionRequestsResponseVO.getIdentityMap().get("player_name"));
			assertNotNull(listTransactionRequestsResponseVO.getIdentityMap().get("ethereum_address"));
			assertNotNull(listTransactionRequestsResponseVO.getRecipientMap());
			assertNotNull(listTransactionRequestsResponseVO.getRecipientMap().get("identity_id"));
			assertNotNull(listTransactionRequestsResponseVO.getRecipientMap().get("player_name"));
			assertNotNull(listTransactionRequestsResponseVO.getRecipientMap().get("ethereum_address"));
			assertNotNull(listTransactionRequestsResponseVO.getType());
			assertNotNull(listTransactionRequestsResponseVO.getIcon());
			assertNotNull(listTransactionRequestsResponseVO.getTitle());
			assertNotNull(listTransactionRequestsResponseVO.getValueMap());
		}
	}
	
	@Test
	public void testCreateTransactionRequest() {		
		//Test the create identity request
		
		Map<String, Object> listIdentityMap = new HashMap<>();
		listIdentityMap.put("player_name", "Joe");
		Map<String, Object> listRecipientMap = new HashMap<>();
		listRecipientMap.put("player_name", "Alice");
		Map<String, Object> createValueMap = new HashMap<>();
		createValueMap.put("ENJ", "3000000000000000000");
		
		CreateTransactionRequestRequestVO createTransactionRequestRequestVO = new CreateTransactionRequestRequestVO();
		createTransactionRequestRequestVO.setAuth("xxxxxxxx");
		createTransactionRequestRequestVO.setIdentityMap(listIdentityMap);
		createTransactionRequestRequestVO.setRecipientMap(listRecipientMap);
		createTransactionRequestRequestVO.setType("send");
		createTransactionRequestRequestVO.setIcon("https://enjincoin.io/images/bubble.png");
		createTransactionRequestRequestVO.setTitle("Mineplex: /transfer alice 3 ENJ");
		createTransactionRequestRequestVO.setValueMap(createValueMap);
		
		CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequests.createTransactionRequest(createTransactionRequestRequestVO);
		assertNotNull(createTransactionRequestResponseVO);
		assertNotNull(createTransactionRequestResponseVO.getTxrId());
		assertNotNull(createTransactionRequestResponseVO.getIdentityMap());
		assertNotNull(createTransactionRequestResponseVO.getIdentityMap().get("identity_id"));
		assertNotNull(createTransactionRequestResponseVO.getIdentityMap().get("player_name"));
		assertNotNull(createTransactionRequestResponseVO.getIdentityMap().get("ethereum_address"));
		assertNotNull(createTransactionRequestResponseVO.getRecipientMap());
		assertNotNull(createTransactionRequestResponseVO.getRecipientMap().get("identity_id"));
		assertNotNull(createTransactionRequestResponseVO.getRecipientMap().get("player_name"));
		assertNotNull(createTransactionRequestResponseVO.getRecipientMap().get("ethereum_address"));
		assertNotNull(createTransactionRequestResponseVO.getType());
		assertNotNull(createTransactionRequestResponseVO.getIcon());
		assertNotNull(createTransactionRequestResponseVO.getTitle());
		assertNotNull(createTransactionRequestResponseVO.getValueMap());
		assertNotNull(createTransactionRequestResponseVO.getValueMap().get("ENJ"));
	}

	@Test
	public void testCancelTransactionRequest() {		
		CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = new CancelTransactionRequestRequestVO();
		cancelTransactionRequestRequestVO.setAuth("xxxxxxxx");
		cancelTransactionRequestRequestVO.setTxrId("123456");

		CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequests.cancelTransactionRequest(cancelTransactionRequestRequestVO);
		assertNotNull(cancelTransactionRequestResponseVO);
		assertNotNull(cancelTransactionRequestResponseVO.getResult());
	}
	

}
