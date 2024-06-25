package base.services;

import base.Element;
import base.waits.WaitStrategy;

public interface ElementWaitService {
    void wait(Element element, WaitStrategy waitStrategy);
}
