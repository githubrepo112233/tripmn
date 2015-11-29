package com.tripmn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripmn.constants.PlatformConstants;
import com.tripmn.dto.CouponDTO;
import com.tripmn.dto.FetchCouponResponse;
import com.tripmn.entity.Coupon;
import com.tripmn.enums.CouponServiceMessage;
import com.tripmn.repository.CouponRepository;
import com.tripmn.service.CouponService;
import com.tripmn.utils.PlatformUtils;

@Service("couponService")
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponRepository couponRepository;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	@Transactional
	public FetchCouponResponse fetchAllCoupons() {
		
		FetchCouponResponse response = new FetchCouponResponse();
		List<Coupon> coupons = (List<Coupon>) couponRepository.findAll();
		List<CouponDTO> couponList = new ArrayList<CouponDTO>();
		for(Coupon coupon : coupons){
			CouponDTO couponDTO = mapper.map(coupon, CouponDTO.class);
			couponDTO.setCouponId(coupon.getId());
			couponDTO.setExpiryDate(PlatformUtils.formatDate(coupon.getExpiryDate(), PlatformConstants.DEFAULT_DATE_FORMAT));
			couponList.add(couponDTO);
		}
		if(couponList.size() <= 0){
			PlatformUtils.addError(response, CouponServiceMessage.COUPONS_NOT_AVAILABLE);
			return response;
		}
		response.setCouponList(couponList);
		return response;
	}
}
