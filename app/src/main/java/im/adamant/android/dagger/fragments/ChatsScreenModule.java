package im.adamant.android.dagger.fragments;

import im.adamant.android.Screens;
import im.adamant.android.avatars.Avatar;
import im.adamant.android.interactors.GetChatListInteractor;
import im.adamant.android.interactors.GetContactsInteractor;
import im.adamant.android.interactors.RefreshChatsInteractor;
import im.adamant.android.ui.presenters.ChatsPresenter;
import im.adamant.android.helpers.ChatsStorage;
import im.adamant.android.ui.adapters.ChatsAdapter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import im.adamant.android.ui.fragments.ChatsScreen;
import io.reactivex.disposables.CompositeDisposable;
import ru.terrakok.cicerone.Router;

@Module
public class ChatsScreenModule {
    @FragmentScope
    @Provides
    public ChatsAdapter provideAdapter(
            ChatsScreen chatsScreen,
            Avatar avatar
    ){
        return new ChatsAdapter(null, chatsScreen, avatar);
    }

    @FragmentScope
    @Provides
    public static ChatsPresenter provideChatsPresenter(
            Router router,
            GetContactsInteractor getContactsInteractor,
            GetChatListInteractor getChatListInteractor,
            ChatsStorage chatsStorage
    ){
        return new ChatsPresenter(router, getContactsInteractor, getChatListInteractor, chatsStorage);
    }
}
