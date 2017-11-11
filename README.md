# merchant

* 欢迎页 http://localhost:8080/user/welcome
* 新增用户 http://localhost:8080/user/add/{password}/{username}
* 查询用户 http://localhost:8080/user/get/username/{username}
-----------------------------------------
工程运行命令 mvn clean spring-boot:run
工程打包命令 mvn clean package [-Pdev] 这个打包还不完善，需要添加打war包功能
