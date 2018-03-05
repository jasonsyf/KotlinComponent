package com.jason_sunyf.core.http.rxfamily;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
/**
 * rxjava 实现时间传递  类似eventBus
 * Created by Jason_Sunyf on 2017/12/9 0009.
 * Email： jason_sunyf@163.com
 */

public class RxBus {
    // 主题
    private final FlowableProcessor<Object> bus;

    // PublishSubject只会把在订阅发生的时间点之后来自原始Flowable的数据发射给观察者
    private RxBus() {
        bus = PublishProcessor.create().toSerialized();
    }

    static RxBus getDefault() {
        return RxBusHolder.sInstance;
    }

    private static class RxBusHolder {
        private static final RxBus sInstance = new RxBus();
    }


    // 提供了一个新的事件
    public void post(Object o) {
        bus.onNext(o);
    }


    // 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
    public <T> Flowable<T> toFlowable(Class<T> eventType) {
        return bus.ofType(eventType);
    }


    /**
     * 提供了一个新的事件,根据code进行分发
     *
     * @param code 事件code
     * @param o
     */
    public void post(int code, Object o) {
        bus.onNext(new RxMessage(code, o));

    }

    /**
     * 根据传递的code和 eventType 类型返回特定类型(eventType)的 被观察者
     *
     * @param code      事件code
     * @param eventType 事件类型
     * @param <T>
     * @return
     */
    public <T> Flowable<T> toFlowable(final int code, final Class<T> eventType) {
        return bus.ofType(RxMessage.class)
                .filter(new Predicate<RxMessage>() {
                    @Override
                    public boolean test(RxMessage rxMessage) throws Exception {
                        //过滤code和eventType都相同的事件
                        return rxMessage.getCode() == code && eventType.isInstance(rxMessage.getObject());
                    }

                }).map(new Function<RxMessage, Object>() {
                    @Override
                    public Object apply(RxMessage rxMessage) throws Exception {
                        return rxMessage.getObject();
                    }
                }).cast(eventType);
    }


    // 封装默认订阅
    <T> Disposable toDefaultFlowable(Class<T> eventType, Consumer<T> act) {
        return bus.ofType(eventType).compose(RxUtil.<T>rxSchedulerHelper()).subscribe(act);
    }
}
