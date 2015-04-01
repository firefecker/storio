package com.pushtorefresh.storio.contentprovider.operation.put;

import org.junit.Test;

import rx.Observable;

public class PreparedPutObjectsTest {

    @Test
    public void putObjectsBlocking() {
        final PutStub putStub = PutStub.newPutStubForMultipleItems();

        final PutCollectionResult<TestItem> putCollectionResult = putStub.storIOContentProvider
                .put()
                .objects(putStub.items)
                .withMapFunc(putStub.mapFunc)
                .withPutResolver(putStub.putResolver)
                .prepare()
                .executeAsBlocking();

        putStub.verifyBehaviorForMultiple(putCollectionResult);
    }

    @Test
    public void putObjectsObservable() {
        final PutStub putStub = PutStub.newPutStubForMultipleItems();

        final Observable<PutCollectionResult<TestItem>> putCollectionResultObservable = putStub.storIOContentProvider
                .put()
                .objects(putStub.items)
                .withMapFunc(putStub.mapFunc)
                .withPutResolver(putStub.putResolver)
                .prepare()
                .createObservable();

        putStub.verifyBehaviorForMultiple(putCollectionResultObservable);
    }
}
