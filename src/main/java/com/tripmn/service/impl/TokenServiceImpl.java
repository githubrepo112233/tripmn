package com.tripmn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripmn.constants.PlatformConstants;
import com.tripmn.dto.FetchTokensResponse;
import com.tripmn.dto.TokenDTO;
import com.tripmn.entity.Token;
import com.tripmn.enums.TokenServceMessage;
import com.tripmn.repository.TokenRepository;
import com.tripmn.service.TokenService;
import com.tripmn.utils.PlatformUtils;

@Service("tokenService")
public class TokenServiceImpl implements TokenService {

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private Mapper mapper;

	@Override
	@Transactional
	public FetchTokensResponse fetchAllTokens() {

		FetchTokensResponse response = new FetchTokensResponse();

		List<TokenDTO> tokenList = new ArrayList<TokenDTO>();
		List<Token> tokenEntityList = (List<Token>) tokenRepository.findAll();
		for (Token token : tokenEntityList) {
			TokenDTO tokenDTO = mapper.map(token, TokenDTO.class);
			tokenDTO.setExpiryDate(PlatformUtils.formatDate(token.getExpiryDate(), PlatformConstants.DEFAULT_DATE_FORMAT));
			tokenList.add(tokenDTO);
		}

		if (tokenList.size() <= 0) {
			PlatformUtils.addError(response, TokenServceMessage.TOKENS_NOT_AVAILABLE);
			return response;
		}

		response.setTokenList(tokenList);

		return response;
	}
}
