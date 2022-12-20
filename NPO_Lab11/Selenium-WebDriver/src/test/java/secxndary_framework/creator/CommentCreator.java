package secxndary_framework.creator;
import secxndary_framework.model.Comment;
import secxndary_framework.utils.TestDataReader;


public class CommentCreator {

    public static final String TESTDATA_COMMENT_TEXT = "testdata.text.comment";
    public static final String TESTDATA_FEEDBACK_TEXT = "testdata.text.feedback";
    public static final String TESTDATA_SEARCH_TEXT = "testdata.text.search";
    public static final int TESTDATA_NUMBER_OF_GOODS = Integer.parseInt("testdata.number.goods");

    public static Comment getCommentText(String commentText) {
        return new Comment(commentText);
    }

    public static Comment getFeedbackText(String feedbackText) {
        Comment comment = new Comment();
        comment.setFeedbackText(feedbackText);
        return comment;
    }

    public static Comment getSearchText(String searchText) {
        Comment comment = new Comment();
        comment.setSearchText(searchText);
        return comment;
    }

    public static Comment getNumberOfGoods(int numberOfGoods) {
        Comment comment = new Comment();
        comment.setNumberOfGoods(numberOfGoods);
        return comment;       }
}
