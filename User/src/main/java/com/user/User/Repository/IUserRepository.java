package com.user.User.Repository;

import com.user.User.Model.HotelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<HotelUser,String> {
}
