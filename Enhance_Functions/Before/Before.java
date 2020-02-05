package Enhance_Functions.Before;

import Enhance_Functions.BseInterface;

import java.lang.reflect.Method;

public interface Before extends BseInterface {
    @Override
    public void excute(Method method, Object object, Object [] args);
}
