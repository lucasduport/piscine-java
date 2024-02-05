package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.INotificationSender;

import java.util.ArrayList;
import java.util.List;

public class User implements IMultiNotificationSender{

    private final String _username;
    private final List<INotificationSender> _parNotificationList;
    public User(final String username, final List<INotificationSender> parNotificationList)
    {
        _username = username;
        _parNotificationList = parNotificationList;
    }
    public User(final String username)
    {
        _username = username;
        _parNotificationList = new ArrayList<>();
    }
    public String getUsername()
    {
        return _username;
    }

    @Override
    public void sendNotifications(String parRecipient, String parMessage) {
        for (var parNotifier: _parNotificationList
             ) {
            parNotifier.notify(this._username, parRecipient, parMessage);
        }
    }

    @Override
    public void addNotifier(INotificationSender parNotifier) {
        _parNotificationList.add(parNotifier);
    }

    @Override
    public List<INotificationSender> getNotifiers() {
        return _parNotificationList;
    }
}
