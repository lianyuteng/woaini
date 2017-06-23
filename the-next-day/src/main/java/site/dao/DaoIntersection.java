package site.dao;

import java.util.List;
import site.entity.Intersection;

public abstract interface DaoIntersection
{
  public abstract List<Intersection> getAllIntersection();
}