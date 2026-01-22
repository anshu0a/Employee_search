
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class EmpTable {
   public static final String DB_URL ="YOUR MYSQL DATABASE URL (UNIFORM RESOURCE LOCATOR)";
   public static final String DB_USER ="YOUR MYSQL DATABASE NAME";
	 public static final String DB_PASS ="YOUR MYSQL DATABASE PASSWORD";
  
   public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            StringBuilder sql = new StringBuilder("SELECT * FROM EMP");
            StringBuilder fil = new StringBuilder();
            int cnt = 0;

            System.out.println("Apply filter:\n");

            String st = IO.readln("Enter id: ");
            Integer id = -1;
            if (!st.isEmpty()) id = Integer.valueOf(st);

            String name = null, dept = null, loc = null;
            Character gender = 'N';
            Double sal = -1.0;

            if (id == -1) {
                name = IO.readln("Enter name: ");
                String g = IO.readln("Enter gender(M\\F\\O): ").toUpperCase();
                if (!g.isEmpty()) gender = g.charAt(0);
                dept = IO.readln("Enter department name: ");
                String s = IO.readln("Enter salary range from 0 to: ");
                if (!s.isEmpty()) sal = Double.valueOf(s);
                loc = IO.readln("Enter location: ");
            }

            if (id != -1) {
                sql.append(" WHERE ID = ?");
                fil.append("Id: ").append(id).append(", ");
            } else {
                if (name != null && !name.isBlank()) {
                    sql.append(cnt == 0 ? " WHERE" : " AND").append(" NAME = ?");
                    fil.append("Name: ").append(name).append(", ");
                    cnt++;
                }
                if (gender != 'N') {
                    sql.append(cnt == 0 ? " WHERE" : " AND").append(" GENDER = ?");
                    fil.append("Gender: ").append(gender).append(", ");
                    cnt++;
                }
                if (dept != null && !dept.isBlank()) {
                    sql.append(cnt == 0 ? " WHERE" : " AND").append(" DEPT = ?");
                    fil.append("Department: ").append(dept).append(", ");
                    cnt++;
                }
                if (sal != -1.0) {
                    sql.append(cnt == 0 ? " WHERE" : " AND").append(" SAL <= ?");
                    fil.append("Salary: ").append(sal).append(", ");
                    cnt++;
                }
                if (loc != null && !loc.isBlank()) {
                    sql.append(cnt == 0 ? " WHERE" : " AND").append(" LOC = ?");
                    fil.append("Location: ").append(loc).append(", ");
                    cnt++;
                }
            }

            PreparedStatement ps = conn.prepareStatement(sql.toString());
            cnt = 0;

            if (id != -1) {
                ps.setInt(1, id);
            } else {
                if (name != null && !name.isBlank()) ps.setString(++cnt, name);
                if (gender != 'N') ps.setString(++cnt, gender.toString());
                if (dept != null && !dept.isBlank()) ps.setString(++cnt, dept);
                if (sal != -1.0) ps.setDouble(++cnt, sal);
                if (loc != null && !loc.isBlank()) ps.setString(++cnt, loc);
            }


            ResultSet res = ps.executeQuery();
            ResultSetMetaData meta = res.getMetaData();

            System.out.println("\n+----+-------+--------+-----------+-----------+--------+");
            System.out.printf("| %-2s | %-5s | %-6s | %-9s | %-9s | %-6s |\n",
                    meta.getColumnName(1), meta.getColumnName(2),
                    meta.getColumnName(3), meta.getColumnName(4),
                    meta.getColumnName(5), meta.getColumnName(6));
            System.out.println("+----+-------+--------+-----------+-----------+--------+");

            boolean found = false;
            while (res.next()) {
                found = true;
                System.out.printf("| %-2d | %-5s | %-6s | %-9s | %-9.2f | %-6s |\n",
                        res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getDouble(5), res.getString(6));
            }

            if (!found)
                System.out.println("No data found for filters [" + fil + "]");

            System.out.println("+----+-------+--------+-----------+-----------+--------+");
            System.out.println("Filters: " + fil);

        } catch (Exception e) {
            System.err.println("---------------- error ------------------");
            e.printStackTrace();
        }

        System.out.println("\nEnd!");
    }
}
