package Enhance_Functions.LoopAround;

import Enhance_Functions.BseInterface;

import java.lang.reflect.Method;

public interface LoopAround extends BseInterface {
    @Override
    public void excute(Method method, Object object, Object [] args);
}
