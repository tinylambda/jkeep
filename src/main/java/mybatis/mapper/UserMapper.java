package mybatis.mapper;

import mybatis.bean.User;

public interface UserMapper {
    User findById(Long id);
}
