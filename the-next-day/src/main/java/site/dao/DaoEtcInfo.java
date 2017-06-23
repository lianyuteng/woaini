package site.dao;

import java.util.List;
import site.entity.EtcInfo;

public abstract interface DaoEtcInfo
{
  public abstract List<EtcInfo> queryEtcAll();

  public abstract EtcInfo queryEtcById(int paramInt);

public abstract int verify(int id);
}
