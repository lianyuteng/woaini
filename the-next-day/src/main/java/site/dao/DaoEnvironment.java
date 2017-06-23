package site.dao;


import java.util.List;
import site.entity.Environment;

public abstract interface DaoEnvironment
{
  public abstract List<Environment> getAllEnvironmentInformation();
}