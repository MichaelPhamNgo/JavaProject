package program_from;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.alee.laf.WebLookAndFeel;

import controller.DBUtil;
import model.Details;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DetailsForm {

	public JFrame frmChiTi;

	private JLabel txtIDsv;
	private JLabel txtHotensv;
	private JLabel txtNgaysinhsv;
	private JLabel txtDiachisv;
	private JLabel txtSdtSv;
	private JLabel txtBac;
	private JLabel txtIDgv;
	private JLabel txtTengv;
	private JLabel txtGioitinhgv;
	private JLabel txtMonday;
	private JLabel txtSdtgv;
	private JLabel txtEmail;
	private JLabel txtGioitinhsv;
	private JLabel txtKhoahoc;
	private JLabel txtNgaysinhgv;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsForm window = new DetailsForm();
					window.frmChiTi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DetailsForm() {
		initialize();
		// WebLookAndFeel.install();
	}

	public void actionDetails(Details details) {
		txtIDsv.setText(details.getIDsinhvien());
		txtHotensv.setText(details.getHotensv());
		txtGioitinhsv.setText(details.getGioitinhsv());
		txtNgaysinhsv.setText(details.getNgaysinhsv());
		txtDiachisv.setText(details.getDiachisv());
		txtSdtSv.setText(details.getSdtsv());
		txtBac.setText(details.getBac());
		txtKhoahoc.setText(details.getKhoahoc());

		txtIDgv.setText(details.getIDgiaovien());
		txtTengv.setText(details.getHotengv());
		txtGioitinhgv.setText(details.getGioitinhgv());
		txtNgaysinhgv.setText(details.getNgaysinhgv());
		txtMonday.setText(details.getMonday());
		txtSdtgv.setText(details.getSdtgv());
		txtEmail.setText(details.getEmail());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChiTi = new JFrame();
		frmChiTi.setResizable(false);
		frmChiTi.setIconImage(Toolkit.getDefaultToolkit().getImage("./icon/Windows-View-Detail-icon.png"));
		frmChiTi.setTitle("Thông tin bổ sung");
		frmChiTi.setBounds(500, 280, 347, 344);
		frmChiTi.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 341, 316);
		frmChiTi.getContentPane().add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Sinh viên", null, panel_1, null);

		JLabel label = new JLabel("M\u00E3 sinh vi\u00EAn");
		label.setBounds(24, 42, 115, 14);

		JLabel label_1 = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		label_1.setBounds(24, 65, 115, 20);

		JLabel label_2 = new JLabel("Ngay sinh");
		label_2.setBounds(24, 118, 115, 20);

		JLabel lblaCh = new JLabel("Số điện thoại");
		lblaCh.setBounds(24, 183, 115, 14);

		JLabel lblKhaHc = new JLabel("Bậc");
		lblKhaHc.setBounds(24, 213, 115, 14);

		txtIDsv = new JLabel("");
		txtIDsv.setBounds(163, 36, 155, 20);

		txtHotensv = new JLabel("");
		txtHotensv.setBounds(163, 65, 155, 20);

		txtNgaysinhsv = new JLabel("");
		txtNgaysinhsv.setBounds(163, 118, 155, 20);

		txtDiachisv = new JLabel("");
		txtDiachisv.setBounds(163, 148, 155, 20);

		txtSdtSv = new JLabel("");
		txtSdtSv.setBounds(163, 178, 155, 20);

		txtBac = new JLabel("");
		txtBac.setBounds(163, 208, 155, 20);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(204, 204, 255));
		menuBar.setBounds(0, 0, 336, 26);

		JMenuItem mntmTenMuc = new JMenuItem("Tên Danh Mục");
		mntmTenMuc.setBackground(SystemColor.menu);
		menuBar.add(mntmTenMuc);

		JMenuItem mntmThongTin = new JMenuItem("Thông Tin");
		mntmThongTin.setBackground(SystemColor.menu);
		menuBar.add(mntmThongTin);

		JLabel lblSinThoi = new JLabel("Địa chỉ");
		lblSinThoi.setBounds(24, 148, 115, 20);
		panel_1.setLayout(null);
		panel_1.add(label);
		panel_1.add(label_1);
		panel_1.add(label_2);
		panel_1.add(lblaCh);
		panel_1.add(lblKhaHc);
		panel_1.add(txtIDsv);
		panel_1.add(txtHotensv);
		panel_1.add(txtNgaysinhsv);
		panel_1.add(txtDiachisv);
		panel_1.add(txtSdtSv);
		panel_1.add(txtBac);
		panel_1.add(menuBar);
		panel_1.add(lblSinThoi);
		
		JLabel lblGiiTnh_1 = new JLabel("Giới tính");
		lblGiiTnh_1.setBounds(24, 90, 115, 20);
		panel_1.add(lblGiiTnh_1);
		
		txtGioitinhsv = new JLabel("");
		txtGioitinhsv.setBounds(163, 90, 155, 20);
		panel_1.add(txtGioitinhsv);
		
		JLabel label_3 = new JLabel("Khóa học");
		label_3.setBounds(24, 243, 115, 14);
		panel_1.add(label_3);
		
		txtKhoahoc = new JLabel("");
		txtKhoahoc.setBounds(163, 238, 155, 20);
		panel_1.add(txtKhoahoc);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Giáo viên", null, panel, null);
		panel.setLayout(null);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(new Color(204, 204, 255));
		menuBar_1.setBounds(0, 0, 336, 27);
		panel.add(menuBar_1);

		JMenuItem mntmTnDanhMc = new JMenuItem("Tên Danh Mục");
		menuBar_1.add(mntmTnDanhMc);

		JMenuItem mntmThngTin = new JMenuItem("Thông Tin");
		menuBar_1.add(mntmThngTin);

		JLabel lblMGioVin = new JLabel("Mã giáo viên");
		lblMGioVin.setBounds(25, 44, 115, 14);
		panel.add(lblMGioVin);

		JLabel label_7 = new JLabel("Họ và tên");
		label_7.setBounds(25, 65, 115, 20);
		panel.add(label_7);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(25, 219, 115, 14);
		panel.add(lblEmail);

		JLabel lblMnDy = new JLabel("ID Môn dạy");
		lblMnDy.setBounds(25, 154, 115, 14);
		panel.add(lblMnDy);

		JLabel lblSinThoi_1 = new JLabel("Số điện thoại");
		lblSinThoi_1.setBounds(25, 189, 115, 14);
		panel.add(lblSinThoi_1);

		txtIDgv = new JLabel("");
		txtIDgv.setBounds(164, 38, 152, 20);
		panel.add(txtIDgv);

		txtTengv = new JLabel("");
		txtTengv.setBounds(164, 65, 152, 20);
		panel.add(txtTengv);

		txtGioitinhgv = new JLabel("");
		txtGioitinhgv.setBounds(164, 90, 152, 20);
		panel.add(txtGioitinhgv);

		txtMonday = new JLabel("");
		txtMonday.setBounds(164, 150, 152, 20);
		panel.add(txtMonday);

		txtSdtgv = new JLabel("");
		txtSdtgv.setBounds(164, 185, 152, 20);
		panel.add(txtSdtgv);

		txtEmail = new JLabel("");
		txtEmail.setBounds(164, 214, 152, 20);
		panel.add(txtEmail);

		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setBounds(25, 90, 115, 20);
		panel.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setBounds(25, 121, 115, 14);
		panel.add(lblNgySinh);
		
		txtNgaysinhgv = new JLabel("");
		txtNgaysinhgv.setBounds(164, 117, 152, 20);
		panel.add(txtNgaysinhgv);
	}
}
