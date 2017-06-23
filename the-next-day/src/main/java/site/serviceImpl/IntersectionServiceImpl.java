package site.serviceImpl;


import com.alibaba.fastjson.JSON;
import java.util.List;
import javax.annotation.Resource;
import site.dao.DaoIntersection;
import org.springframework.stereotype.Service;

@Service
public class IntersectionServiceImpl
{

  @Resource(name="daoIntersection")
  private DaoIntersection dao;

  public String getTotalIntersectionInformation()
  {
    List allIntersection = this.dao.getAllIntersection();
    String jsonString = JSON.toJSONString(allIntersection);

    return jsonString;
  }
}
