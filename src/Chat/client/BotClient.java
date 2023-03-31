package Chat.client;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    protected boolean shouldSendTextFromConsole() {
        // Бот не должен отправлять текст введенный с консоли
        return false;
    }

    @Override
    protected String getUserName() {
        // Каждый раз генерируем новое имя бота на случайб если к серверу подключится несколько ботов
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        // Создаем и запускаем бот клиента
        Client client = new BotClient();
        client.run();
    }

    public class BotSocketThread extends SocketThread {

    }
}
