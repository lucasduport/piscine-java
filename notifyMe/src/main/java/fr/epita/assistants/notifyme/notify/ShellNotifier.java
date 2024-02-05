package fr.epita.assistants.notifyme.notify;

public class ShellNotifier implements INotificationSender
{
    /**
     * Constructor
     * @param parStdErr if true, print to stderr, otherwise print to stdout
     */
    private final boolean _parStdErr;
    public ShellNotifier(final boolean parStdErr)
    {
        _parStdErr = parStdErr;
    }

    @Override
    public void notify(String parSender, String parReceiver, String parMessage) {
        if (_parStdErr)
        {
            System.err.println("Notification from " + parSender + " to " + parReceiver + " received: " + parMessage);
        }
        else
        {
            System.out.println("Notification from " + parSender + " to " + parReceiver + " received: " + parMessage);
        }
    }
}
