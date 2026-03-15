package ex5;

public class Ticket {
    private String ticketId;
    private String roomName;
    private boolean isVIP;
    private boolean isHeld;
    private boolean isSold;
    private long holdExpiryTime;
    private String heldBy;

    public Ticket(String ticketId, String roomName, boolean isVIP) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isVIP = isVIP;
        this.isHeld = false;
        this.isSold = false;
    }

    public String getTicketId() {
        return ticketId;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public boolean isSold() {
        return isSold;
    }

    public long getHoldExpiryTime() {
        return holdExpiryTime;
    }

    public String getHeldBy() {
        return heldBy;
    }

    // danh dau ve dang duoc giu
    public void hold(String counterName) {
        isHeld = true;
        heldBy = counterName;
        holdExpiryTime = System.currentTimeMillis() + 5000;
    }
    // thanh toan ve
    public void sell() {
        isSold = true;
        isHeld = false;
    }

    // tra lai ve khi het han
    public void release() {
        isHeld = false;
        heldBy = null;
    }
}
