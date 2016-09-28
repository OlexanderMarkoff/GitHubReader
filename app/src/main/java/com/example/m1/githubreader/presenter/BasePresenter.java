package com.example.m1.githubreader.presenter;

import com.example.m1.githubreader.view.interfaces.GiHubReaderView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Markov O on 26.09.16.
 */

public abstract class BasePresenter<T extends GiHubReaderView> implements Presenter<T> {

    protected T view;

    protected BasePresenter() {
    }

    public static Presenter getInstance() {
        throw new RuntimeException("You need to override in children. Children must be singletons.");
    }

    @Override
    public void subscribe(T view) {
        this.view = view;
    }


    public static class PresenterManager {

        private static final List<Presenter> PRESENTERS = new ArrayList<Presenter>();

        private PresenterManager() {
        }

        public static Presenter getPresenter(Class<? extends BasePresenter> clazz) {

            if (PRESENTERS.size() == 0 || !PRESENTERS.contains(clazz)) {
                try {
                    PRESENTERS.add(clazz.newInstance());
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
            for (Presenter p : PRESENTERS) {
                if (clazz.isAssignableFrom(p.getClass())) {
                    return p;
                }
            }
            return null;
        }

        public static void removePresenter(Presenter presenter) {
            PRESENTERS.remove(presenter);
        }
    }
}



