package Enhance_Functions.After;

import Enhance_Functions.BseInterface;

import java.lang.reflect.Method;

public interface After extends BseInterface {
    @Override
    public void excute(Method method, Object object, Object [] args);
}
