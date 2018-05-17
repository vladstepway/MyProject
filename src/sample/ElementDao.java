package sample;

import java.util.ArrayList;

public  interface ElementDao<T>
{
     ArrayList<T> getAll();

     boolean update(T paramT);

     boolean delete(int paramInt);

     boolean add(T paramT);
}
