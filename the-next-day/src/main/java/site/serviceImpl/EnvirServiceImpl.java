package site.serviceImpl;


import com.alibaba.fastjson.JSON;
import java.util.List;
import javax.annotation.Resource;
import site.dao.DaoEnvironment;
import org.springframework.stereotype.Service;

@Service
public class EnvirServiceImpl

{

  @Resource(name="daoEnvironment")
  private DaoEnvironment environment;

  public String getEnvirInfo()
  {
    List information = this.environment.getAllEnvironmentInformation();
    String jsonString = JSON.toJSONString(information);
    return jsonString;
  }
}
