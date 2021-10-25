package dongjoo.second.quitsmoking.common.dto;

import java.io.Serializable;
import java.util.List;

import dongjoo.second.quitsmoking.common.entity.History;
import dongjoo.second.quitsmoking.common.entity.User;

public class ConfirmCancelDialogDto implements Serializable {

    private List<History> histories; //전표 / 카드사용내역 용도
    private User user;

    public ConfirmCancelDialogDto() {
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
