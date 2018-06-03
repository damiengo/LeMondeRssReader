package org.mbach.lemonde.home;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * RssItem class.
 *
 * @author Matthieu BACHELIER
 * @since 2017-05
 */
public class RssItem implements Parcelable {

    public static final int ARTICLE_TYPE = 0;
    public static final int DATE_GROUP_TYPE = 1;

    private String link = null;
    private String title = null;
    private Integer articleId = null;
    private String enclosure = null;
    private String category = null;
    private long pubDate;
    private int type;

    public static final Parcelable.Creator<RssItem> CREATOR = new Parcelable.Creator<RssItem>() {
        public RssItem createFromParcel(@NonNull Parcel in) {
            return new RssItem(in);
        }

        public RssItem[] newArray(int size) {
            return new RssItem[size];
        }
    };

    private RssItem(Parcel in) {
        link = in.readString();
        title = in.readString();
        articleId = in.readInt();
        enclosure = in.readString();
        pubDate = in.readLong();
        type = ARTICLE_TYPE;
    }

    public RssItem(int type) {
        this.type = type;
    }

    @Nullable
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    @Nullable
    public int getArticleId() {
        return this.articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Nullable
    public long getPubDate() {
        return pubDate;
    }

    public void setPubDate(long pubDate) {
        this.pubDate = pubDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(link);
        dest.writeString(title);
        dest.writeInt(articleId);
        dest.writeString(enclosure);
        dest.writeLong(pubDate);
    }
}