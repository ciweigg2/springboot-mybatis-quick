### 项目使用的技术和工具

> Mybatis plus 生成工具
* MyBatisCodeHelperPro

> 映射对象工具
* MapStruct

> yapi和生成文档插件
* yapi和YapiUpload

YapiUpload插件配置单模块项目 .idea中misc.xml添加下面内容

```xml
<component name="yapi">
  <option name="projectToken">token</option>
  <option name="projectId">id</option>
  <option name="yapiUrl">http://localhost:3000</option>
  <option name="projectType">api</option>
  <option name="attachUploadUrl">http://localhost/fileupload</option>
</component>
```

Alt+U选择类或者方法上传就行了

> 新建类注释模板(兼容yapi)

```bash
/**
 *@className ${NAME}
 *@description
 *@author ${USER}
 *@date ${DATE} ${TIME}
 *@menu
**/
```

> 新建方法注释(兼容yapi)

使用idea插件 EasyJavadoc 导入配置好的模板 easy_javadoc.json 点击方法/类使用command + \ 生成注释 更多功能参考官网 点击中文可以生成英文驼峰

> smart-doc文档

暂时使用smart-doc生成postman请求例子 smart-doc生成文档并不好用推荐使用yapi 建议使用maven插件生成

> Diboot自动化开发框架

封装了通用的mybatis-plus查询条件 返回分页转换vo返回多表关联的数据 绑定数据字典枚举 比如gender=M显示M对应的性别

使用教程：https://www.diboot.com/guide/diboot-core/%E5%AE%89%E8%A3%85.html

> mybatis-plus动态数据源

需要注意的是 数据库添加的数据源必须有一个是标识master的 这边有初始化sql可以参考 pool_name是数据库标识

`自定义加载数据源列表`

默认为yml读取数据源 如果需要实现读取数据库需要继承AbstractDataSourceProvider实现loadDataSources接口

这边已经实现了 请参考：[JdbcDataSourceProvider](src/main/java/com/mxc/springbootmybatisquick/dynamic/JdbcDataSourceProvider.java)

`自定义设置当前数据源`

官方默认使用@DS注解 我们通过拦截器设置

通过拦截器拦截header为ds的参数 动态设置当前请求使用的数据源 当然可以不用header用session都行的

`测试接口`

通过header参数ds切换当前使用的数据源 不传默认master 如果传了个当前没有的数据源也会默认选择master

查询列表：

```bash
根据业务header传入ds=xxx
POST
http://localhost:8080/dynamic/listWithDto2
{
  "object": {},
  "size": 2,
  "current": 1,
  "orders": [
    {
      "serialVersionUID": 0,
      "column": "userName",
      "asc": false
    }
  ]
}
```

查看当前所有数据源：

```bash
GET
http://localhost:8080/dynamic
```

添加数据源：

```bash
header设置master 可以按需修改 这边主库需要保存所有添加过的数据源 为了下次启动默认加载到内存
POST
http://localhost:8080/dynamic
{
    "pollName": "11",
    "username": "root",
    "password": "123456",
    "driverClassName":"com.mysql.cj.jdbc.Driver",
    "url": "jdbc:mysql://127.0.0.1:3309/bl3?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2b8&allowPublicKeyRetrieval=true"
}
```

删除数据源：

```bash
DELETE
http://localhost:8080/dynamic?name=xxx
```