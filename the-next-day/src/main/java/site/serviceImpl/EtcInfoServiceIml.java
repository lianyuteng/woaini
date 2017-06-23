package site.serviceImpl;

import com.alibaba.fastjson.JSON;
import java.io.PrintStream;
import java.util.List;
import javax.annotation.Resource;
import site.dao.DaoEtcInfo;
import site.entity.EtcInfo;
import org.springframework.stereotype.Service;

@Service
public class EtcInfoServiceIml {

	@Resource(name = "daoEtcInfo")
	private DaoEtcInfo dei;

	public String getEtcAllInfo() {
		List all = this.dei.queryEtcAll();
		String jsonString = JSON.toJSONString(all);

		return jsonString;
	}

	public String getEtcInfoByCarId(int id) {
		EtcInfo info = this.dei.queryEtcById(id);
		String jsonString = JSON.toJSONString(info);
		System.out.println(jsonString);
		return jsonString;
	}

	public int  verify(int id) {
		int result = dei.verify(id);
		
		return result;
	}
}