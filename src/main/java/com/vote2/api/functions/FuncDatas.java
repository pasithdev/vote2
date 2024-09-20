package com.vote2.api.functions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vote2.api.models.MdlClearRed;
import com.vote2.api.models.MdlColorMode;
import com.vote2.api.models.MdlGetDataVote;
import com.vote2.api.models.MdlGetMaxDateTime;
import com.vote2.api.models.MdlGetShowCountActive;
import com.vote2.api.models.MdlLogId;
import com.vote2.api.models.MdlMaxPersonId;
import com.vote2.api.models.MdlParam;
import com.vote2.api.models.MdlPhotoPath;
import com.vote2.api.models.MdlPopupPosition;
import com.vote2.api.models.MdlResult;
import com.vote2.api.models.MdlRowColor;
import com.vote2.api.models.MdlSortMode;
import com.vote2.api.models.MdlTotalScore;
import com.vote2.api.models.MldCountMode;
import com.vote2.api.models.MldSelectStatus;

public class FuncDatas {

    public MdlPhotoPath getPhotoPath(String url, String username, String password) {

        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlPhotoPath mdlPhotoPath = new MdlPhotoPath();
        try {//stmt statement
            CallableStatement stmt = conn.prepareCall("{CALL sp_get_photo_path()}");
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlPhotoPath.setPathId(rs.getInt("path_id"));
                mdlPhotoPath.setPath(rs.getString("path"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlPhotoPath;
    }

    public MdlRowColor getRowColor(String url, String username, String password) {

        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlRowColor mdlRowColor = new MdlRowColor();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_row_color_phack_13()}");
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlRowColor.setRowValue(rs.getInt("row_value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlRowColor;
    }

    public MdlTotalScore getTotalScore(String url, String username, String password) {

        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlTotalScore mdlTotalScore = new MdlTotalScore();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_total_score_phack()}");
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlTotalScore.setTotalScore(rs.getInt("total_score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlTotalScore;
    }

    public MdlLogId getMaxLogId(String url, String username, String password) {

        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlLogId mdlLogId = new MdlLogId();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_max_log_id_13()}");
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlLogId.setPersonId(rs.getInt("person_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlLogId;
    }

    public MdlMaxPersonId getPersonIdLogId(String url, String username, String password) {

        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlMaxPersonId maxPersonId = new MdlMaxPersonId();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_person_id_equal_max_log()}");
            rs = stmt.executeQuery();
            while(rs.next()) {
                maxPersonId.setMaxPersonId(rs.getInt("p_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return maxPersonId;
    }

    public MdlMaxPersonId getMaxPersonId(String url, String username, String password) {

        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlMaxPersonId mdlMaxPersonId = new MdlMaxPersonId();
        try {//stmt statement
            CallableStatement stmt = conn.prepareCall("{CALL sp_get_max_person_id_13()}"); 
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlMaxPersonId.setMaxPersonId(rs.getInt("p_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlMaxPersonId;
    }

    public MdlClearRed getClearRed(String url, String username, String password) {

        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        MdlClearRed mdlClearRed = new MdlClearRed();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_clear_red()}");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                mdlClearRed.setStatusName(rs.getString("status_name"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }   
        return mdlClearRed;
    }

    public MdlSortMode getSortMode(String url, String username, String password) {

        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlSortMode mdlSortMode = new MdlSortMode();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_sort_mode()}");
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlSortMode.setSortMode(rs.getInt("m_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlSortMode;
    }

    public MdlColorMode getColorMode(String url, String username, String password) {
        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlColorMode mdlColorMode = new MdlColorMode();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_color_mode()}");
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlColorMode.setId(rs.getInt("id"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlColorMode;

    }

    public List<MdlGetDataVote> getData(int sortMode, String url, String username, String password) {
        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        
        List<MdlGetDataVote> mdlGetDataVotes = new ArrayList<MdlGetDataVote>();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_data_phack_13(?)}");
            stmt.setInt(1, sortMode);
            rs = stmt.executeQuery();
            while(rs.next()) {
                MdlGetDataVote mdlGetDataVote = new MdlGetDataVote();
                mdlGetDataVote.setPhotoName(rs.getString("photo_name"));
                mdlGetDataVote.setName(rs.getString("name"));
                mdlGetDataVote.setScore(rs.getInt("score"));
                mdlGetDataVote.setTotalScore(rs.getInt("total_score"));
                mdlGetDataVote.setpId(rs.getInt("p_id"));
                mdlGetDataVotes.add(mdlGetDataVote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlGetDataVotes;

    }

    public MldCountMode getCountMode(String url, String username, String password) {
        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MldCountMode mldCountMode = new MldCountMode();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_count_mode()}");
            rs = stmt.executeQuery();
            while(rs.next()) {
                mldCountMode.setCountMode(rs.getInt("c_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mldCountMode;

    }

    //this store procedure is not appaliable
    public MldSelectStatus getSelectStatus(String url, String username, String password){
        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MldSelectStatus mldSelectStatus = new MldSelectStatus();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_select_status()}"); //this store procedure is not appaliable
            rs = stmt.executeQuery();
            while(rs.next()) {
                mldSelectStatus.setSelectStatus(rs.getString("select_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            mldSelectStatus.setSelectStatus("N");
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mldSelectStatus;
    }

    public MdlResult updateClearSelect(String url, String username, String password) {
        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        MdlResult mdlResult = new MdlResult();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_update_clear_select_phack_13()}");
            stmt.executeUpdate();
            mdlResult.setResult("true");
        } catch (SQLException e) {
            e.printStackTrace();
            mdlResult.setResult("false");
            return mdlResult;
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlResult;

    }

    public MdlParam getParam(int paramId, String url, String username, String password) {
        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlParam mdlParam = new MdlParam();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_get_param(?)}");
            stmt.setInt(1, paramId);
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlParam.setParamValue(rs.getString("param_value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlParam;

    }

    public MdlGetShowCountActive getShowCountActive(String url, String username, String password) {
        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlGetShowCountActive mdlGetShowCountActive = new MdlGetShowCountActive();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_show_count_active_13()}");
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlGetShowCountActive.setShowCountActiveCnt(rs.getInt("cnt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlGetShowCountActive;
    }
    
    public MdlGetMaxDateTime getMaxDateTime(String url, String username, String password) {
        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlGetMaxDateTime mdlGetMaxDateTime = new MdlGetMaxDateTime();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_max_date_log_13()}");
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlGetMaxDateTime.setMaxDateTime(rs.getString("max_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlGetMaxDateTime;
    }

    public MdlResult updateClearShow(String url, String username, String password) {
        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        MdlResult mdlResult = new MdlResult();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_update_clear_show_phack_13()}");
            stmt.executeUpdate();
            mdlResult.setResult("true");
        } catch (SQLException e) {
            e.printStackTrace();
            mdlResult.setResult("false");
            return mdlResult;
        }
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlResult;
    }

    public MdlPopupPosition getPopupPosition(String url, String username, String password) {
        ConnectionDB connection = new ConnectionDB();
        Connection conn = connection.getConnectionDB(url, username, password);
        ResultSet rs = null;
        MdlPopupPosition mdlPopupPosition = new MdlPopupPosition();
        try {//stmt statement
        CallableStatement stmt = conn.prepareCall("{CALL sp_get_popup_position(?)}");
            stmt.setInt(1, 1);
            rs = stmt.executeQuery();
            while(rs.next()) {
                mdlPopupPosition.setPx(rs.getDouble("p_x"));
                mdlPopupPosition.setPy(rs.getDouble("p_y"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        try {
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return mdlPopupPosition;
    }
}
