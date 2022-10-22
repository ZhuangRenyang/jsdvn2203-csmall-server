package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumMapper {
    /**
     * 插入品牌数据
     * @param album 品牌数据
     * @return 受影响的行数，成功插入数据，返回值为1
     */
    int insert(Album album);
    /**
     * 根据品牌id，删除品牌数据
     *
     * @param id 期望删除的品牌数据的id
     * @return 受影响的行数，当删除成功时，将返回1，如果无此id对应的数据，将返回0
     */
    int deleteById(Long id);

    int deleteByIds(Long... id);

    /**
     * 根据id 修改品牌的名称 @Param注解来标记对应的参数名称
     *  JVM底层编译运行程序时，默认时不会保存局部变量名称的，由于方法的参数也是局部变量，所以参数的名称在
     *  编译时就消失了，运行时不能保存，导致Mybatis默认情况下多个参数时，是不能能直接使用参数名称对应#{}中
     *  的内容，但是Springboot官方脚手架创建的java项目JVM参数进行了修改，是的方法的局部变量名称也能保存，
     *  所以直接编写变量名就可以对应#{}里面的名称，但是使用阿里云的脚手架创建的项目就没有进行JVM参数的修改，
     *  就不能直接编写变量名称，就会导致程序报错。为了保证程序的运行，最后在参数前加@Param注解来标记参数名称
     * @param id 品牌的id
     * @param name 新品牌的名称
     * @return 受影响的行数，当修改成功时，返回1，如果无此id对应的数据，则返回0
     */
    int updateNameById(@Param("id") Long id,@Param("name") String name);
}
