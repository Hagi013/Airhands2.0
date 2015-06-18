package jp.co.airhands2.welcomehome.application.controller;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


/**
 * ユーザマスタ関連画面に対応するコントローラクラスです。
 * @author u103531
 * @version 1.0
 * @since 1.0
 */
public class BaseController implements Serializable {
    

    /**
     * ERRORレベルのFacesMessageを追加します。
     * @param summary メッセージサマリ
     * @param detail メッセージ詳細
     */
    protected void addErrorMessage(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
    }

    /**
     * FacesMessageをContextへ追加します。
     * @param serverity メッセージレベル
     * @param summary メッセージサマリ
     * @param detail メッセージ詳細
     */
    private void addMessage(FacesMessage.Severity serverity, String summary, String detail) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage(serverity, summary, detail));
    }


    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    /** 会話スコープ管理用オブジェクト */
    @Inject
    protected Conversation conversation;

    /**
     * 会話スコープを開始します。
     */
    protected void beginConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    /**
     * 会話スコープを終了します。
     */
    protected void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    /**
     * 指定されたページへのリダイレクト用文字列を取得します。
     * @param path リダイレクト先ページ
     * @return リダイレクト用文字列
     */
    protected String redirectTo(String path) {
        return path + "?faces-redirect=true";
    }
}




