package com.code.fuqinqin.designPattern.observer.org.impls;

import com.code.fuqinqin.designPattern.observer.org.Observer;
import com.code.fuqinqin.designPattern.observer.org.Subject;

/**
 * <p></p>
 *
 * @author fuqinqin3
 * @version 1.0
 * @date 2021/1/13 16:24
 */
public class BObserver extends Observer {
    public BObserver(Subject subject) {
        super.subject = subject;
        super.subject.attach(this);
    }

    @Override
    protected void update(int state) {
        System.out.println("BObserver state = " + state);
    }
}
