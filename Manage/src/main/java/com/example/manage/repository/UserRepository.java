package com.example.manage.repository;

import com.example.manage.dto.response.UserResponse;
import com.example.manage.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
            SELECT new com.example.manage.dto.response.UserResponse
            (u.id,u.age, u.sex,
            a.id, a.username, a.password,
            f.id, f.firstName, f.middleName, f.lastName,
            s.id, s.apartNumber, s.commune, s.district, s.city, s.country
            )
            from User u
            left join Account  a  ON a.id = u.id
            left join FullName f ON f.id = u.id
            left join Address s ON s.id = u.id
            where u.id = :id
            """)
    UserResponse detail(Long id);

    @Query("""
            SELECT new com.example.manage.dto.response.UserResponse
            (u.id,u.age, u.sex,
            a.id, a.username, a.password,
            f.id, f.firstName, f.middleName, f.lastName,
            s.id, s.apartNumber, s.commune, s.district, s.city, s.country
            )
            from User u
            left join Account  a  ON a.id = u.id
            left join FullName f ON f.id = u.id
            left join Address s ON s.id = u.id
            where u.isDelete = false
            order by u.id
            """)
    Page<UserResponse> findAllUsers(Pageable pageable);

    @Query("""
            SELECT new com.example.manage.dto.response.UserResponse
            (u.id,u.age, u.sex,
            a.id, a.username, a.password,
            f.id, f.firstName, f.middleName, f.lastName,
            s.id, s.apartNumber, s.commune, s.district, s.city, s.country
            )
            from User u
            left join Account  a  ON a.id = u.id
            left join FullName f ON f.id = u.id
            left join Address s ON s.id = u.id
            WHERE (:keyword is null or
            lower(u.sex) LIKE lower(concat('%', :keyword, '%')) or
            lower(u.age) LIKE lower(concat('%', :keyword, '%')) or
            lower(f.firstName) LIKE lower(concat('%', :keyword, '%')))
            AND u.isDelete = false
            ORDER BY u.id
            """)
    Page<UserResponse> search(PageRequest pageRequest, @Param("keyword") String keyword);


}
