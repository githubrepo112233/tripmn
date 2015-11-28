package com.tripmn.repository;

import org.springframework.data.repository.Repository;
import com.tripmn.entity.UserCoupon;

public interface UserCouponRepository extends Repository<UserCoupon, Long>,
		BaseRepository<UserCoupon, Long>, UserCouponRepositoryCustom {

}