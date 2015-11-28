package com.tripmn.repository;

import org.springframework.data.repository.Repository;
import com.tripmn.entity.Coupon;

public interface CouponRepository extends Repository<Coupon, Long>,
		BaseRepository<Coupon, Long>, CouponRepositoryCustom {

}
