package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import org.mindrot.jbcrypt.BCrypt;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import bao.AttendancerecordBao;
import bao.DepartmentBao;
import bao.EmployeeBao;
import bao.RelativesBao;
import bao.RequestchangeShiftBao;
import bao.RequestleaveBao;
import bao.ShiftBao;
import entities.Employee;
import entities.Relatives;
import entities.RequestchangeShift;
import entities.Requestleave;
import entities.Shift;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;

public class ClientAdminHr extends JFrame {
	private Employee employee;
	private EmployeeBao empBao;
	private Login login = new Login();
	private JPanel contentPane;
	private GradientPanel panelMain;
	private JPanel panelMenu;
	private JPanel panelMyProfile;
	private JPanel panelHeader;
	private JPanel panelInformation;
	private JPanel panelLeave;
	private JPanel panelRelative;
	private JLabel lblInformation;
	private JLabel lblFullname;
	private JTextField textFieldFullname;
	private JLabel lblDob;
	private JTextField textFieldDob;
	private JLabel lblGender;
	private JTextField textFieldGender;
	private JTextField textFieldDepartment;
	private JLabel lblDepartment;
	private JLabel lblAddress;
	private JTextField textFieldAddress;
	private JLabel lblPhone;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JLabel lblEmail;
	private JLabel lblOnboardDate;
	private JLabel lblUnpaidLeave;
	private JLabel lblAnnualLeave;
	private JLabel lblSickLeave;
	private JTextField textFieldOD;
	private JTextField textFieldUL;
	private JTextField textFieldAL;
	private JTextField textFieldSL;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnCreateRequest;
	private JPanel panelLogo;
	private JLabel lblNewLabel_5;
	private JButton btnMyProfile;
	private JButton btnChangePass;
	private JButton btnLogOut;
	private JButton btnNotification;
	private JLabel lblFullnameRE;
	private JTextField textFieldFullnameRE;
	private JLabel lblRelation;
	private JTextField textFieldRelation;
	private JLabel lblPhoneRE;
	private JPanel panelRequestLeave;
	private JPanel panel_23;
	private JLabel lblNewLabel_6;
	private JRadioButton rdbtnAL;
	private JRadioButton rdbtnUL;
	private JRadioButton rdbtnSL;
	private JLabel lblNewLabel_8;
	private JDateChooser dateChooserFrom;
	private JLabel lblNewLabel_9;
	private JDateChooser dateChooserTo;
	private JLabel lblToAdmin;
	private JButton btnSubmit;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblDayType;
	private JComboBox comboBoxDayType;
	private JLabel lblShift;
	private JComboBox comboBox;
	private boolean check;
	private JPanel panelCalendar;
	private JPanel panelChangePass;
	private JPanel panel_25;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JButton btnChangePassword;
	private JPanel panel_24;
	private JPasswordField passwordFieldPass;
	private JPasswordField passwordFieldNewPass;
	private JPasswordField passwordFieldRePass;
	private JPanel panel_27;
	private JPanel panel_28;
	private JCalendar calendar;
	private JPanel panel_22;
	private JLabel lblNewLabel_16;
	private JPanel panel_26;
	private JLabel lblNewLabel_21;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JTextField textFieldDateInfo;
	private JLabel lblNewLabel_24;
	private JTextField textFieldShiftInfo;
	private JButton btnGoToRQL;
	private JLabel lblNewLabel_25;
	private JTextField textFieldWorkTimeInfo;
	private JLabel lblNewLabel_26;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_28;
	private JTextField textField_7;
	private JLabel lblNewLabel_29;
	private JPanel panelNotification;
	private JPanel panelNotifiMain;
	private JScrollPane scrollPane_2;
	private JPanel panel_30;
	private JPanel panel_32;
	private JLabel lblNewLabel_30;
	private JPanel panel_35;
	private JPanel panelRELeave;
	private JPanel panel_43;
	private JPanel panel_44;
	private JLabel lblNewLabel_43;
	private JTextField textFieldReFrom;
	private JLabel lblNewLabel_44;
	private JTextField textFieldReTo;
	private JLabel lblNewLabel_45;
	private JTextField textFieldReType;
	private JLabel lblNewLabel_46;
	private JTextField textFieldReAdmin;
	private JButton btnCalendar;
	private JLabel lblNewLabel_48;
	private JLabel lblNewLabel_49;
	private JPanel borderlaoutpanel = new JPanel();
	private JPanel columnpanel = new JPanel();
	JLabel idRe = new JLabel();
	private JLabel lblNewLabel_52;
	private JTextField textFieldTotalDate;
	private JLabel lblNewLabel_53;
	private JTextField textFieldStatus;
	private JTextField textField_2;
	private JLabel lblNewLabel_54;
	private JLabel lblRePassError;
	private JLabel lblNewPassError;
	private JLabel lblPassError;
	private JLabel lblNewLabel_55;
	private JLabel lblNewLabel_56;
	private JLabel lblNewLabel_57;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblFromToError;
	private JLabel lblDept;
	private JLabel lblNewLabel_59;
	private JLabel lblEmpName;
	private JButton btnRequestLeave;
	private JLabel lblNewLabel_60;
	private JTextField textFieldDateLimit;
	private JLabel lblNewLabel_12;
	private JLabel lbl_showALinyear;
	private JLabel lblNewLabel_63;
	private JLabel lblNewLabel_64;
	private JLabel lblNewLabel_65;
	private JLabel lblNewLabel_66;
	private JTextField textFieldPhoneRE;
	private JComboBox listAdmin;
	private JLabel lblFromError;
	private JLabel lblToError;
	private JLabel lblAdminError;
	private JLabel lblNewLabel_62;
	private JTextField textFieldTo;
	private JButton btnBack;
	private JLabel lblNewLabel_51;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientAdminHr frame = new ClientAdminHr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * Create the frame.
	 */
	public ClientAdminHr() {
		ImageIcon submit = new ImageIcon(ClientAdminHr.class.getResource("/Images/submit.png"), "submit");
		ImageIcon change_pass = new ImageIcon(ClientAdminHr.class.getResource("/Images/checked.png"), "change");

		setResizable(false);
		setTitle("Traverloto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1301, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelMain = new GradientPanel(Color.white, Color.white, 3);
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new CardLayout(0, 0));

		GradientPanel panelMyProfile = new GradientPanel(Color.white, Color.white, 3);
//		panelMyProfile = new JPanel();
		panelMyProfile.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMyProfile.setBackground(Color.GRAY);
		panelMain.add(panelMyProfile, "my_profile");

		panelHeader = new JPanel();
		panelHeader.setOpaque(false);
		panelHeader.setBackground(Color.WHITE);

		lblInformation = new JLabel("Personal Information");
		lblInformation.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 51, 153)));
		lblInformation.setForeground(new Color(0, 51, 153));
		lblInformation.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelHeader.add(lblInformation);

		panelInformation = new JPanel();
		panelInformation.setOpaque(false);
		panelInformation.setBackground(Color.WHITE);
		panelInformation.setForeground(new Color(0, 0, 0));
		panelInformation.setBorder(new CompoundBorder(new EmptyBorder(10, 80, 10, 80),
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 255), new Color(0, 51, 153)),
						"INFORMATION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		GridBagLayout gbl_panelInformation = new GridBagLayout();
		gbl_panelInformation.columnWidths = new int[] { 39, 56, 0, 233, 0, 350, 0, 0 };
		gbl_panelInformation.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelInformation.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelInformation.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panelInformation.setLayout(gbl_panelInformation);

		lblFullname = new JLabel("Fullname: ");
		lblFullname.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblFullname = new GridBagConstraints();
		gbc_lblFullname.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullname.anchor = GridBagConstraints.WEST;
		gbc_lblFullname.gridx = 2;
		gbc_lblFullname.gridy = 0;
		panelInformation.add(lblFullname, gbc_lblFullname);

		textFieldFullname = new JTextField();
		textFieldFullname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldFullname.setBorder(null);
		textFieldFullname.setFocusable(false);
		textFieldFullname.setBackground(Color.WHITE);
		textFieldFullname.setEditable(false);
		GridBagConstraints gbc_textFieldFullname = new GridBagConstraints();
		gbc_textFieldFullname.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFullname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFullname.gridx = 3;
		gbc_textFieldFullname.gridy = 0;
		panelInformation.add(textFieldFullname, gbc_textFieldFullname);
		textFieldFullname.setColumns(10);

		lblDob = new JLabel("Dob: ");
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDob.setHorizontalAlignment(SwingConstants.CENTER);
		lblDob.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDob = new GridBagConstraints();
		gbc_lblDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblDob.anchor = GridBagConstraints.WEST;
		gbc_lblDob.gridx = 4;
		gbc_lblDob.gridy = 0;
		panelInformation.add(lblDob, gbc_lblDob);

		textFieldDob = new JTextField();
		textFieldDob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDob.setBorder(null);
		textFieldDob.setFocusable(false);
		textFieldDob.setBackground(Color.WHITE);
		textFieldDob.setEditable(false);
		GridBagConstraints gbc_textFieldDob = new GridBagConstraints();
		gbc_textFieldDob.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDob.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDob.gridx = 5;
		gbc_textFieldDob.gridy = 0;
		panelInformation.add(textFieldDob, gbc_textFieldDob);
		textFieldDob.setColumns(10);

		lblGender = new JLabel("Gender : ");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.WEST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 2;
		gbc_lblGender.gridy = 1;
		panelInformation.add(lblGender, gbc_lblGender);

		textFieldGender = new JTextField();
		textFieldGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldGender.setBorder(null);
		textFieldGender.setFocusable(false);
		textFieldGender.setBackground(Color.WHITE);
		textFieldGender.setEditable(false);
		GridBagConstraints gbc_textFieldGender = new GridBagConstraints();
		gbc_textFieldGender.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGender.gridx = 3;
		gbc_textFieldGender.gridy = 1;
		panelInformation.add(textFieldGender, gbc_textFieldGender);
		textFieldGender.setColumns(10);

		lblDepartment = new JLabel("Department: ");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
		gbc_lblDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartment.anchor = GridBagConstraints.WEST;
		gbc_lblDepartment.gridx = 4;
		gbc_lblDepartment.gridy = 1;
		panelInformation.add(lblDepartment, gbc_lblDepartment);

		textFieldDepartment = new JTextField();
		textFieldDepartment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDepartment.setBorder(null);
		textFieldDepartment.setFocusable(false);
		textFieldDepartment.setBackground(Color.WHITE);
		textFieldDepartment.setEditable(false);
		GridBagConstraints gbc_textFieldDepartment = new GridBagConstraints();
		gbc_textFieldDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDepartment.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDepartment.gridx = 5;
		gbc_textFieldDepartment.gridy = 1;
		panelInformation.add(textFieldDepartment, gbc_textFieldDepartment);
		textFieldDepartment.setColumns(10);

		lblPhone = new JLabel("Phone: ");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 2;
		gbc_lblPhone.gridy = 2;
		panelInformation.add(lblPhone, gbc_lblPhone);

		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldPhone.setBorder(null);
		textFieldPhone.setFocusable(false);
		textFieldPhone.setBackground(Color.WHITE);
		textFieldPhone.setEditable(false);
		GridBagConstraints gbc_textFieldPhone = new GridBagConstraints();
		gbc_textFieldPhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPhone.gridx = 3;
		gbc_textFieldPhone.gridy = 2;
		panelInformation.add(textFieldPhone, gbc_textFieldPhone);
		textFieldPhone.setColumns(10);

		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.gridx = 4;
		gbc_lblEmail.gridy = 2;
		panelInformation.add(lblEmail, gbc_lblEmail);

		panelLeave = new JPanel();
		panelLeave.setOpaque(false);
		panelLeave.setBackground(Color.WHITE);
		panelLeave.setBorder(new CompoundBorder(new EmptyBorder(0, 80, 10, 80),
				new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 153, 255), new Color(0, 153, 204)),
						"LEAVE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		GridBagLayout gbl_panelLeave = new GridBagLayout();
		gbl_panelLeave.columnWidths = new int[] { 35, 136, 161, 114, 295, 0, 0 };
		gbl_panelLeave.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelLeave.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelLeave.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panelLeave.setLayout(gbl_panelLeave);

		lblOnboardDate = new JLabel("Onboard Date: ");
		lblOnboardDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblOnboardDate = new GridBagConstraints();
		gbc_lblOnboardDate.anchor = GridBagConstraints.WEST;
		gbc_lblOnboardDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblOnboardDate.gridx = 1;
		gbc_lblOnboardDate.gridy = 0;
		panelLeave.add(lblOnboardDate, gbc_lblOnboardDate);

		textFieldOD = new JTextField();
		textFieldOD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldOD.setBorder(null);
		textFieldOD.setFocusable(false);
		textFieldOD.setBackground(Color.WHITE);
		textFieldOD.setEditable(false);
		GridBagConstraints gbc_textFieldOD = new GridBagConstraints();
		gbc_textFieldOD.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldOD.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOD.gridx = 2;
		gbc_textFieldOD.gridy = 0;
		panelLeave.add(textFieldOD, gbc_textFieldOD);
		textFieldOD.setColumns(10);

		lblNewLabel_12 = new JLabel("Total AL In Year:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 1;
		panelLeave.add(lblNewLabel_12, gbc_lblNewLabel_12);

		lbl_showALinyear = new JLabel("12");
		lbl_showALinyear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lbl_showALinyear = new GridBagConstraints();
		gbc_lbl_showALinyear.anchor = GridBagConstraints.WEST;
		gbc_lbl_showALinyear.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_showALinyear.gridx = 2;
		gbc_lbl_showALinyear.gridy = 1;
		panelLeave.add(lbl_showALinyear, gbc_lbl_showALinyear);

		lblAnnualLeave = new JLabel("Total AL Left:");
		lblAnnualLeave.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblAnnualLeave = new GridBagConstraints();
		gbc_lblAnnualLeave.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		gbc_lblAnnualLeave.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnnualLeave.gridx = 3;
		gbc_lblAnnualLeave.gridy = 1;
		panelLeave.add(lblAnnualLeave, gbc_lblAnnualLeave);

		textFieldAL = new JTextField();
		textFieldAL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldAL.setBorder(null);
		textFieldAL.setFocusable(false);
		textFieldAL.setBackground(Color.WHITE);
		textFieldAL.setEditable(false);
		textFieldAL.setColumns(10);
		GridBagConstraints gbc_textFieldAL = new GridBagConstraints();
		gbc_textFieldAL.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAL.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAL.gridx = 4;
		gbc_textFieldAL.gridy = 1;
		panelLeave.add(textFieldAL, gbc_textFieldAL);

		lblNewLabel_63 = new JLabel("Total SL In Year:");
		lblNewLabel_63.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_63 = new GridBagConstraints();
		gbc_lblNewLabel_63.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_63.gridx = 1;
		gbc_lblNewLabel_63.gridy = 2;
		panelLeave.add(lblNewLabel_63, gbc_lblNewLabel_63);

		lblNewLabel_66 = new JLabel("30");
		lblNewLabel_66.setFont(new Font("SansSerif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_66 = new GridBagConstraints();
		gbc_lblNewLabel_66.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_66.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_66.gridx = 2;
		gbc_lblNewLabel_66.gridy = 2;
		panelLeave.add(lblNewLabel_66, gbc_lblNewLabel_66);

		lblSickLeave = new JLabel("Total SL Left:");
		lblSickLeave.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblSickLeave = new GridBagConstraints();
		gbc_lblSickLeave.anchor = GridBagConstraints.WEST;
		gbc_lblSickLeave.insets = new Insets(0, 0, 5, 5);
		gbc_lblSickLeave.gridx = 3;
		gbc_lblSickLeave.gridy = 2;
		panelLeave.add(lblSickLeave, gbc_lblSickLeave);

		textFieldSL = new JTextField();
		textFieldSL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldSL.setBorder(null);
		textFieldSL.setFocusable(false);
		textFieldSL.setBackground(Color.WHITE);
		textFieldSL.setEditable(false);
		textFieldSL.setColumns(10);
		GridBagConstraints gbc_textFieldSL = new GridBagConstraints();
		gbc_textFieldSL.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSL.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSL.gridx = 4;
		gbc_textFieldSL.gridy = 2;
		panelLeave.add(textFieldSL, gbc_textFieldSL);

		panelRelative = new JPanel();
		panelRelative.setOpaque(false);
		panelRelative.setBackground(Color.WHITE);
		panelRelative.setBorder(new CompoundBorder(new EmptyBorder(0, 80, 10, 80),
				new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 153, 255), new Color(51, 153, 204)),
						"RELATIVE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		GridBagLayout gbl_panelRelative = new GridBagLayout();
		gbl_panelRelative.columnWidths = new int[] { 40, 162, 212, 101, 319, 0, 0 };
		gbl_panelRelative.rowHeights = new int[] { 42, 0, 32, 0 };
		gbl_panelRelative.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelRelative.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelRelative.setLayout(gbl_panelRelative);

		lblFullnameRE = new JLabel("Fullname: ");
		lblFullnameRE.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblFullnameRE = new GridBagConstraints();
		gbc_lblFullnameRE.anchor = GridBagConstraints.WEST;
		gbc_lblFullnameRE.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullnameRE.gridx = 1;
		gbc_lblFullnameRE.gridy = 0;
		panelRelative.add(lblFullnameRE, gbc_lblFullnameRE);

		textFieldFullnameRE = new JTextField();
		textFieldFullnameRE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldFullnameRE.setBorder(null);
		textFieldFullnameRE.setEditable(false);
		textFieldFullnameRE.setFocusable(false);
		GridBagConstraints gbc_textFieldFullnameRE = new GridBagConstraints();
		gbc_textFieldFullnameRE.gridwidth = 3;
		gbc_textFieldFullnameRE.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFullnameRE.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFullnameRE.gridx = 2;
		gbc_textFieldFullnameRE.gridy = 0;
		panelRelative.add(textFieldFullnameRE, gbc_textFieldFullnameRE);
		textFieldFullnameRE.setColumns(10);

		lblRelation = new JLabel("Relation: ");
		lblRelation.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblRelation = new GridBagConstraints();
		gbc_lblRelation.anchor = GridBagConstraints.WEST;
		gbc_lblRelation.insets = new Insets(0, 0, 5, 5);
		gbc_lblRelation.gridx = 1;
		gbc_lblRelation.gridy = 1;
		panelRelative.add(lblRelation, gbc_lblRelation);

		textFieldRelation = new JTextField();
		textFieldRelation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldRelation.setBorder(null);
		textFieldRelation.setEditable(false);
		textFieldRelation.setFocusable(false);
		GridBagConstraints gbc_textFieldRelation = new GridBagConstraints();
		gbc_textFieldRelation.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRelation.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRelation.gridx = 2;
		gbc_textFieldRelation.gridy = 1;
		panelRelative.add(textFieldRelation, gbc_textFieldRelation);
		textFieldRelation.setColumns(10);

		lblPhoneRE = new JLabel("Phone: ");
		lblPhoneRE.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblPhoneRE = new GridBagConstraints();
		gbc_lblPhoneRE.anchor = GridBagConstraints.WEST;
		gbc_lblPhoneRE.insets = new Insets(0, 0, 0, 5);
		gbc_lblPhoneRE.gridx = 1;
		gbc_lblPhoneRE.gridy = 2;
		panelRelative.add(lblPhoneRE, gbc_lblPhoneRE);
		panelMyProfile.setLayout(new BoxLayout(panelMyProfile, BoxLayout.Y_AXIS));
		panelMyProfile.add(panelHeader);
		panelMyProfile.add(panelInformation);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldEmail.setBorder(null);
		textFieldEmail.setFocusable(false);
		textFieldEmail.setBackground(Color.WHITE);
		textFieldEmail.setEditable(false);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 5;
		gbc_textFieldEmail.gridy = 2;
		panelInformation.add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);

		lblAddress = new JLabel("Address: ");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddress.gridx = 2;
		gbc_lblAddress.gridy = 3;
		panelInformation.add(lblAddress, gbc_lblAddress);

		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldAddress.setBorder(null);
		textFieldAddress.setFocusable(false);
		textFieldAddress.setBackground(Color.WHITE);
		textFieldAddress.setEditable(false);
		GridBagConstraints gbc_textFieldAddress = new GridBagConstraints();
		gbc_textFieldAddress.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldAddress.gridwidth = 3;
		gbc_textFieldAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAddress.gridx = 3;
		gbc_textFieldAddress.gridy = 3;
		panelInformation.add(textFieldAddress, gbc_textFieldAddress);
		textFieldAddress.setColumns(10);
		panelMyProfile.add(panelLeave);

		lblNewLabel_64 = new JLabel("Total UL In Year:");
		lblNewLabel_64.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_64 = new GridBagConstraints();
		gbc_lblNewLabel_64.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_64.gridx = 1;
		gbc_lblNewLabel_64.gridy = 3;
		panelLeave.add(lblNewLabel_64, gbc_lblNewLabel_64);

		lblNewLabel_65 = new JLabel("15");
		lblNewLabel_65.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_65 = new GridBagConstraints();
		gbc_lblNewLabel_65.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_65.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_65.gridx = 2;
		gbc_lblNewLabel_65.gridy = 3;
		panelLeave.add(lblNewLabel_65, gbc_lblNewLabel_65);

		lblUnpaidLeave = new JLabel("Total UL Left:");
		lblUnpaidLeave.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblUnpaidLeave = new GridBagConstraints();
		gbc_lblUnpaidLeave.anchor = GridBagConstraints.WEST;
		gbc_lblUnpaidLeave.insets = new Insets(0, 0, 0, 5);
		gbc_lblUnpaidLeave.gridx = 3;
		gbc_lblUnpaidLeave.gridy = 3;
		panelLeave.add(lblUnpaidLeave, gbc_lblUnpaidLeave);

		textFieldUL = new JTextField();
		textFieldUL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldUL.setBorder(null);
		textFieldUL.setFocusable(false);
		textFieldUL.setBackground(Color.WHITE);
		textFieldUL.setEditable(false);
		GridBagConstraints gbc_textFieldUL = new GridBagConstraints();
		gbc_textFieldUL.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldUL.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUL.gridx = 4;
		gbc_textFieldUL.gridy = 3;
		panelLeave.add(textFieldUL, gbc_textFieldUL);
		textFieldUL.setColumns(10);
		panelMyProfile.add(panelRelative);

		textFieldPhoneRE = new JTextField();
		textFieldPhoneRE.setBorder(null);
		textFieldPhoneRE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_textFieldPhoneRE = new GridBagConstraints();
		gbc_textFieldPhoneRE.anchor = GridBagConstraints.WEST;
		gbc_textFieldPhoneRE.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldPhoneRE.fill = GridBagConstraints.VERTICAL;
		gbc_textFieldPhoneRE.gridx = 2;
		gbc_textFieldPhoneRE.gridy = 2;
		panelRelative.add(textFieldPhoneRE, gbc_textFieldPhoneRE);
		textFieldPhoneRE.setColumns(10);

		panelRequestLeave = new JPanel();
		panelRequestLeave.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRequestLeave.setOpaque(false);
		panelRequestLeave.setBackground(new Color(0, 0, 0, 0));
//		panelRequestLeave.setBackground(new Color(255, 255, 255));
		panelMain.add(panelRequestLeave, "request_leave");
		GridBagLayout gbl_panelRequestLeave = new GridBagLayout();
		gbl_panelRequestLeave.columnWidths = new int[] { 66, 876, 52, 0, 0 };
		gbl_panelRequestLeave.rowHeights = new int[] { 51, 35, 598, 26, 0, 0 };
		gbl_panelRequestLeave.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelRequestLeave.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		panelRequestLeave.setLayout(gbl_panelRequestLeave);

		panel_23 = new JPanel();
		panel_23.setBackground(new Color(255, 255, 255));
		panel_23.setBorder(new CompoundBorder(
				new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 51, 204)),
						new EmptyBorder(10, 10, 10, 10)),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 255), new Color(102, 102, 204))));
		GridBagConstraints gbc_panel_23 = new GridBagConstraints();
		gbc_panel_23.insets = new Insets(0, 0, 5, 5);
		gbc_panel_23.fill = GridBagConstraints.BOTH;
		gbc_panel_23.gridx = 1;
		gbc_panel_23.gridy = 2;
		panelRequestLeave.add(panel_23, gbc_panel_23);

		GridBagLayout gbl_panel_23 = new GridBagLayout();
		gbl_panel_23.columnWidths = new int[] { 80, 157, 150, 137, 87, 280, 97, 80 };
		gbl_panel_23.rowHeights = new int[] { 75, 55, 0, 50, 0, 40, 29, 40, 26, -4, 40, 40, 41, 58, 0 };
		gbl_panel_23.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_23.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_23.setLayout(gbl_panel_23);

		lblNewLabel_55 = new JLabel("Leave Request form");
		lblNewLabel_55.setForeground(new Color(0, 0, 153));
		lblNewLabel_55.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 204)));
		GridBagConstraints gbc_lblNewLabel_55 = new GridBagConstraints();
		gbc_lblNewLabel_55.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_55.gridwidth = 8;
		gbc_lblNewLabel_55.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_55.gridx = 0;
		gbc_lblNewLabel_55.gridy = 0;
		panel_23.add(lblNewLabel_55, gbc_lblNewLabel_55);
		lblNewLabel_55.setFont(new Font("Sitka Text", Font.BOLD, 30));

		panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 6;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		panel_23.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 159, 142, 108, 198, 259, 0 };
		gbl_panel_3.rowHeights = new int[] { 60, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		lblNewLabel_56 = new JLabel("Fullname:");
		GridBagConstraints gbc_lblNewLabel_56 = new GridBagConstraints();
		gbc_lblNewLabel_56.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_56.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_56.gridx = 0;
		gbc_lblNewLabel_56.gridy = 0;
		panel_3.add(lblNewLabel_56, gbc_lblNewLabel_56);
		lblNewLabel_56.setFont(new Font("Sitka Text", Font.BOLD, 20));

		lblEmpName = new JLabel("name");
		lblEmpName.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		GridBagConstraints gbc_lblEmpName = new GridBagConstraints();
		gbc_lblEmpName.anchor = GridBagConstraints.WEST;
		gbc_lblEmpName.gridwidth = 2;
		gbc_lblEmpName.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmpName.gridx = 1;
		gbc_lblEmpName.gridy = 0;
		panel_3.add(lblEmpName, gbc_lblEmpName);

		lblNewLabel_57 = new JLabel("Department:");
		GridBagConstraints gbc_lblNewLabel_57 = new GridBagConstraints();
		gbc_lblNewLabel_57.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_57.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_57.gridx = 3;
		gbc_lblNewLabel_57.gridy = 0;
		panel_3.add(lblNewLabel_57, gbc_lblNewLabel_57);
		lblNewLabel_57.setFont(new Font("Sitka Text", Font.BOLD, 20));

		lblDept = new JLabel("dept");
		lblDept.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDept = new GridBagConstraints();
		gbc_lblDept.anchor = GridBagConstraints.WEST;
		gbc_lblDept.gridx = 4;
		gbc_lblDept.gridy = 0;
		panel_3.add(lblDept, gbc_lblDept);

		lblNewLabel_6 = new JLabel("Leave type:");
		lblNewLabel_6.setFont(new Font("Sitka Text", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 3;
		panel_23.add(lblNewLabel_6, gbc_lblNewLabel_6);

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 5;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 3;
		panel_23.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 180, 180, 180, 0 };
		gbl_panel_4.rowHeights = new int[] { 49, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		rdbtnAL = new JRadioButton("Annual leave");
		GridBagConstraints gbc_rdbtnAL = new GridBagConstraints();
		gbc_rdbtnAL.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnAL.gridx = 0;
		gbc_rdbtnAL.gridy = 0;
		panel_4.add(rdbtnAL, gbc_rdbtnAL);
		rdbtnAL.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		rdbtnAL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnAL.setSelected(true);
		buttonGroup.add(rdbtnAL);

		rdbtnUL = new JRadioButton("Unpaid leave");
		GridBagConstraints gbc_rdbtnUL = new GridBagConstraints();
		gbc_rdbtnUL.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnUL.gridx = 1;
		gbc_rdbtnUL.gridy = 0;
		panel_4.add(rdbtnUL, gbc_rdbtnUL);
		rdbtnUL.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		rdbtnUL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonGroup.add(rdbtnUL);

		rdbtnSL = new JRadioButton("Sick leave");
		GridBagConstraints gbc_rdbtnSL = new GridBagConstraints();
		gbc_rdbtnSL.gridx = 2;
		gbc_rdbtnSL.gridy = 0;
		panel_4.add(rdbtnSL, gbc_rdbtnSL);
		rdbtnSL.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		rdbtnSL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonGroup.add(rdbtnSL);

		lblFromError = new JLabel("");
		lblFromError.setForeground(Color.RED);
		GridBagConstraints gbc_lblFromError = new GridBagConstraints();
		gbc_lblFromError.anchor = GridBagConstraints.WEST;
		gbc_lblFromError.gridwidth = 2;
		gbc_lblFromError.insets = new Insets(0, 0, 5, 5);
		gbc_lblFromError.gridx = 2;
		gbc_lblFromError.gridy = 4;
		panel_23.add(lblFromError, gbc_lblFromError);

		lblToError = new JLabel("");
		lblToError.setForeground(Color.RED);
		GridBagConstraints gbc_lblToError = new GridBagConstraints();
		gbc_lblToError.anchor = GridBagConstraints.WEST;
		gbc_lblToError.insets = new Insets(0, 0, 5, 5);
		gbc_lblToError.gridx = 5;
		gbc_lblToError.gridy = 4;
		panel_23.add(lblToError, gbc_lblToError);

		lblNewLabel_8 = new JLabel("From:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 5;
		panel_23.add(lblNewLabel_8, gbc_lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);

		dateChooserFrom = new JDateChooser();
		dateChooserFrom.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		GridBagConstraints gbc_dateChooserFrom = new GridBagConstraints();
		gbc_dateChooserFrom.gridwidth = 2;
		gbc_dateChooserFrom.fill = GridBagConstraints.BOTH;
		gbc_dateChooserFrom.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserFrom.gridx = 2;
		gbc_dateChooserFrom.gridy = 5;
		panel_23.add(dateChooserFrom, gbc_dateChooserFrom);
		dateChooserFrom.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserFrom.setDateFormatString("yyyy-MM-dd");

		dateChooserFrom.setBackground(Color.white);

		lblNewLabel_9 = new JLabel("To:");
		lblNewLabel_9.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 4;
		gbc_lblNewLabel_9.gridy = 5;
		panel_23.add(lblNewLabel_9, gbc_lblNewLabel_9);

		dateChooserTo = new JDateChooser();
		dateChooserTo.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		dateChooserTo.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		dateChooserTo.setBackground(Color.white);
		dateChooserTo.setDateFormatString("yyyy-MM-dd");
		GridBagConstraints gbc_dateChooserTo = new GridBagConstraints();
		gbc_dateChooserTo.fill = GridBagConstraints.BOTH;
		gbc_dateChooserTo.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserTo.gridx = 5;
		gbc_dateChooserTo.gridy = 5;
		panel_23.add(dateChooserTo, gbc_dateChooserTo);

		lblFromToError = new JLabel("");
		lblFromToError.setHorizontalAlignment(SwingConstants.LEFT);
		lblFromToError.setForeground(Color.RED);
		lblFromToError.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		GridBagConstraints gbc_lblFromToError = new GridBagConstraints();
		gbc_lblFromToError.gridwidth = 4;
		gbc_lblFromToError.anchor = GridBagConstraints.NORTH;
		gbc_lblFromToError.insets = new Insets(0, 0, 5, 5);
		gbc_lblFromToError.gridx = 2;
		gbc_lblFromToError.gridy = 6;
		panel_23.add(lblFromToError, gbc_lblFromToError);

		lblDayType = new JLabel("Day Type:");
		lblDayType.setEnabled(false);
		GridBagConstraints gbc_lblDayType = new GridBagConstraints();
		gbc_lblDayType.anchor = GridBagConstraints.EAST;
		gbc_lblDayType.insets = new Insets(0, 0, 5, 5);
		gbc_lblDayType.gridx = 1;
		gbc_lblDayType.gridy = 7;
		panel_23.add(lblDayType, gbc_lblDayType);
		lblDayType.setHorizontalAlignment(SwingConstants.LEFT);
		lblDayType.setFont(new Font("Sitka Text", Font.BOLD, 20));

		comboBoxDayType = new JComboBox();
		comboBoxDayType.setEnabled(false);
		GridBagConstraints gbc_comboBoxDayType = new GridBagConstraints();
		gbc_comboBoxDayType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDayType.gridwidth = 2;
		gbc_comboBoxDayType.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDayType.gridx = 2;
		gbc_comboBoxDayType.gridy = 7;
		panel_23.add(comboBoxDayType, gbc_comboBoxDayType);
		comboBoxDayType.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		comboBoxDayType.setModel(new DefaultComboBoxModel(new String[] { "Full Day", "Half Day" }));
		comboBoxDayType.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxDayType.setBackground(Color.WHITE);

		lblShift = new JLabel("Shift:");
		GridBagConstraints gbc_lblShift = new GridBagConstraints();
		gbc_lblShift.insets = new Insets(0, 0, 5, 5);
		gbc_lblShift.gridx = 4;
		gbc_lblShift.gridy = 7;
		panel_23.add(lblShift, gbc_lblShift);
		lblShift.setEnabled(false);
		lblShift.setHorizontalAlignment(SwingConstants.LEFT);
		lblShift.setFont(new Font("Sitka Text", Font.BOLD, 20));

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 7;
		panel_23.add(comboBox, gbc_comboBox);
		comboBox.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setEnabled(false);
		comboBox.setBackground(Color.WHITE);

		lblAdminError = new JLabel("");
		lblAdminError.setForeground(Color.RED);
		GridBagConstraints gbc_lblAdminError = new GridBagConstraints();
		gbc_lblAdminError.anchor = GridBagConstraints.WEST;
		gbc_lblAdminError.gridwidth = 2;
		gbc_lblAdminError.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdminError.gridx = 2;
		gbc_lblAdminError.gridy = 9;
		panel_23.add(lblAdminError, gbc_lblAdminError);

		lblToAdmin = new JLabel("To Admin:");
		GridBagConstraints gbc_lblToAdmin = new GridBagConstraints();
		gbc_lblToAdmin.anchor = GridBagConstraints.EAST;
		gbc_lblToAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblToAdmin.gridx = 1;
		gbc_lblToAdmin.gridy = 10;
		panel_23.add(lblToAdmin, gbc_lblToAdmin);
		lblToAdmin.setFont(new Font("Sitka Text", Font.BOLD, 20));

		btnSubmit = new JButton("Submit", submit);
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSubmitActionPerformed(e);
			}
		});

		listAdmin = new JComboBox();
		listAdmin.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		listAdmin.setBackground(Color.WHITE);
		GridBagConstraints gbc_listAdmin = new GridBagConstraints();
		gbc_listAdmin.gridwidth = 2;
		gbc_listAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_listAdmin.fill = GridBagConstraints.BOTH;
		gbc_listAdmin.gridx = 2;
		gbc_listAdmin.gridy = 10;
		panel_23.add(listAdmin, gbc_listAdmin);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.anchor = GridBagConstraints.WEST;
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 12;
		panel_23.add(btnSubmit, gbc_btnSubmit);

		panelCalendar = new JPanel();
		panelCalendar.setOpaque(false);
		panelCalendar.setBackground(new Color(0, 0, 0, 0));
		panelMain.add(panelCalendar, "calendar");
		GridBagLayout gbl_panelCalendar = new GridBagLayout();
		gbl_panelCalendar.columnWidths = new int[] { 0, 0, 652, 0, 279, 0, 0, 0 };
		gbl_panelCalendar.rowHeights = new int[] { 46, 480, 100 };
		gbl_panelCalendar.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelCalendar.rowWeights = new double[] { 1.0, 0.0, 0.0 };
		panelCalendar.setLayout(gbl_panelCalendar);

		panel_26 = new JPanel();
		panel_26.setOpaque(false);
		panel_26.setBackground(new Color(0, 0, 0, 0));
		GridBagConstraints gbc_panel_26 = new GridBagConstraints();
		gbc_panel_26.insets = new Insets(0, 0, 5, 5);
		gbc_panel_26.fill = GridBagConstraints.BOTH;
		gbc_panel_26.gridx = 2;
		gbc_panel_26.gridy = 0;
		panelCalendar.add(panel_26, gbc_panel_26);
		panel_26.setLayout(new BorderLayout(0, 0));

		lblNewLabel_21 = new JLabel("Calendar");
		lblNewLabel_21.setForeground(Color.BLACK);
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_21.setBackground(new Color(214, 217, 223));
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setForeground(new Color(0, 0, 153));
		panel_26.add(lblNewLabel_21, BorderLayout.CENTER);

		panel_27 = new JPanel();
		panel_27.setBackground(Color.WHITE);
		panel_27.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_27 = new GridBagConstraints();
		gbc_panel_27.insets = new Insets(0, 0, 5, 5);
		gbc_panel_27.fill = GridBagConstraints.BOTH;
		gbc_panel_27.gridx = 2;
		gbc_panel_27.gridy = 1;
		panelCalendar.add(panel_27, gbc_panel_27);
		panel_27.setLayout(new BorderLayout(0, 0));

		calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setFont(new Font("SansSerif", Font.PLAIN, 15));
		calendar.getYearChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getMonthChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getMonthChooser().getComboBox().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getDayChooser().getDayPanel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.setWeekOfYearVisible(false);
		calendar.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		calendar.getMonthChooser().getSpinner().setBackground(Color.WHITE);
		calendar.getYearChooser().getSpinner().setBackground(Color.WHITE);
		calendar.setBackground(Color.white);
		panel_27.add(calendar, BorderLayout.CENTER);

		panel_28 = new JPanel();
		panel_28.setBackground(Color.WHITE);
		panel_28.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_28.setLayout(null);
		GridBagConstraints gbc_panel_28 = new GridBagConstraints();
		gbc_panel_28.gridwidth = 2;
		gbc_panel_28.insets = new Insets(0, 0, 5, 5);
		gbc_panel_28.fill = GridBagConstraints.BOTH;
		gbc_panel_28.gridx = 3;
		gbc_panel_28.gridy = 1;
		panelCalendar.add(panel_28, gbc_panel_28);

		lblNewLabel_16 = new JLabel("Day Info");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(6, 6, 262, 28);
		lblNewLabel_16.setForeground(new Color(0, 0, 153));
		panel_28.add(lblNewLabel_16);

		lblNewLabel_23 = new JLabel("Date");
		lblNewLabel_23.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_23.setBounds(6, 61, 78, 28);
		panel_28.add(lblNewLabel_23);

		textFieldDateInfo = new JTextField();
		textFieldDateInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldDateInfo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldDateInfo.setFocusable(false);
		textFieldDateInfo.setEditable(false);
		textFieldDateInfo.setBounds(113, 61, 155, 28);
		panel_28.add(textFieldDateInfo);
		textFieldDateInfo.setColumns(10);

		lblNewLabel_24 = new JLabel("Shift");
		lblNewLabel_24.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_24.setBounds(6, 114, 78, 28);
		panel_28.add(lblNewLabel_24);

		textFieldShiftInfo = new JTextField();
		textFieldShiftInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldShiftInfo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldShiftInfo.setFocusable(false);
		textFieldShiftInfo.setEditable(false);
		textFieldShiftInfo.setBounds(113, 114, 155, 28);
		panel_28.add(textFieldShiftInfo);
		textFieldShiftInfo.setColumns(10);

		btnGoToRQL = new JButton("RQ Leave");
		btnGoToRQL.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnGoToRQL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGoToRQLActionPerformed(e);
			}
		});
		btnGoToRQL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoToRQL.setBounds(149, 266, 119, 28);
		panel_28.add(btnGoToRQL);

		lblNewLabel_25 = new JLabel("Start From");
		lblNewLabel_25.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_25.setBounds(6, 165, 100, 28);
		panel_28.add(lblNewLabel_25);

		textFieldWorkTimeInfo = new JTextField();
		textFieldWorkTimeInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldWorkTimeInfo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldWorkTimeInfo.setFocusable(false);
		textFieldWorkTimeInfo.setEditable(false);
		textFieldWorkTimeInfo.setColumns(10);
		textFieldWorkTimeInfo.setBounds(113, 165, 155, 28);
		panel_28.add(textFieldWorkTimeInfo);

		lblNewLabel_62 = new JLabel("To");
		lblNewLabel_62.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_62.setBounds(6, 222, 55, 16);
		panel_28.add(lblNewLabel_62);

		textFieldTo = new JTextField();
		textFieldTo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldTo.setFocusable(false);
		textFieldTo.setEditable(false);
		textFieldTo.setColumns(10);
		textFieldTo.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldTo.setBounds(113, 216, 155, 28);
		panel_28.add(textFieldTo);

		panel_22 = new JPanel();
		panel_22.setBorder(
				new TitledBorder(null, "Note", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_22.setBackground(Color.WHITE);
		panel_22.setLayout(null);
		GridBagConstraints gbc_panel_22 = new GridBagConstraints();
		gbc_panel_22.gridwidth = 3;
		gbc_panel_22.insets = new Insets(0, 0, 5, 5);
		gbc_panel_22.fill = GridBagConstraints.BOTH;
		gbc_panel_22.gridx = 2;
		gbc_panel_22.gridy = 2;
		panelCalendar.add(panel_22, gbc_panel_22);

		textField = new JTextField();
		textField.setBounds(20, 18, 63, 28);
		textField.setBackground(Color.MAGENTA);
		textField.setEditable(false);
		textField.setFocusable(false);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(20, 49, 63, 28);
		textField_1.setBackground(Color.GREEN);
		textField_1.setEditable(false);
		textField_1.setFocusable(false);
		textField_1.setColumns(10);

		lblNewLabel_22 = new JLabel("Shift 1");
		lblNewLabel_22.setBounds(88, 18, 95, 28);

		lblNewLabel_26 = new JLabel("Shift 2");
		lblNewLabel_26.setBounds(88, 49, 95, 28);

		textField_5 = new JTextField();
		textField_5.setBounds(238, 18, 63, 28);
		textField_5.setBackground(Color.CYAN);
		textField_5.setEditable(false);
		textField_5.setFocusable(false);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(238, 49, 63, 28);
		textField_6.setBackground(Color.YELLOW);
		textField_6.setEditable(false);
		textField_6.setFocusable(false);
		textField_6.setColumns(10);

		lblNewLabel_27 = new JLabel("Shift 3");
		lblNewLabel_27.setBounds(306, 18, 95, 28);

		lblNewLabel_28 = new JLabel("Shift 4");
		lblNewLabel_28.setBounds(306, 49, 95, 28);

		textField_7 = new JTextField();
		textField_7.setBounds(477, 18, 63, 28);
		textField_7.setBackground(Color.GRAY);
		textField_7.setFocusable(false);
		textField_7.setEditable(false);
		textField_7.setColumns(10);

		lblNewLabel_29 = new JLabel("Day off");
		lblNewLabel_29.setBounds(545, 18, 95, 28);

		textField_2 = new JTextField();
		textField_2.setBounds(477, 49, 63, 28);
		textField_2.setFocusable(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.PINK);

		lblNewLabel_54 = new JLabel("Half Shift");
		lblNewLabel_54.setBounds(545, 49, 95, 28);
		panel_22.add(textField);
		panel_22.add(lblNewLabel_22);
		panel_22.add(textField_5);
		panel_22.add(lblNewLabel_27);
		panel_22.add(textField_1);
		panel_22.add(lblNewLabel_26);
		panel_22.add(textField_6);
		panel_22.add(lblNewLabel_28);
		panel_22.add(textField_7);
		panel_22.add(lblNewLabel_29);
		panel_22.add(textField_2);
		panel_22.add(lblNewLabel_54);

		panelChangePass = new JPanel();
		panelChangePass.setOpaque(false);
		panelChangePass.setBackground(new Color(0, 0, 0, 0));
		panelMain.add(panelChangePass, "change_pass");
		GridBagLayout gbl_panelChangePass = new GridBagLayout();
		gbl_panelChangePass.columnWidths = new int[] { 0, 0, 997, 0, 0, 0 };
		gbl_panelChangePass.rowHeights = new int[] { 0, 79, -31, 476, 0, 0, 0, 0 };
		gbl_panelChangePass.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelChangePass.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelChangePass.setLayout(gbl_panelChangePass);

		panel_24 = new JPanel();
		panel_24.setOpaque(false);
		panel_24.setBackground(new Color(0, 0, 0, 0));
		GridBagConstraints gbc_panel_24 = new GridBagConstraints();
		gbc_panel_24.insets = new Insets(0, 0, 5, 5);
		gbc_panel_24.fill = GridBagConstraints.BOTH;
		gbc_panel_24.gridx = 2;
		gbc_panel_24.gridy = 1;
		panelChangePass.add(panel_24, gbc_panel_24);
		panel_24.setLayout(new BorderLayout(0, 0));

		panel_25 = new JPanel();
		panel_25.setBackground(Color.WHITE);
		panel_25.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 51, 255), new Color(51, 153, 204))));
		GridBagConstraints gbc_panel_25 = new GridBagConstraints();
		gbc_panel_25.gridheight = 2;
		gbc_panel_25.insets = new Insets(0, 0, 5, 5);
		gbc_panel_25.fill = GridBagConstraints.BOTH;
		gbc_panel_25.gridx = 2;
		gbc_panel_25.gridy = 2;
		panelChangePass.add(panel_25, gbc_panel_25);
		GridBagLayout gbl_panel_25 = new GridBagLayout();
		gbl_panel_25.columnWidths = new int[] { 106, 216, 340, 99, 126, 0 };
		gbl_panel_25.rowHeights = new int[] { 64, 45, 41, 46, 32, 40, 43, 31, 38, 33, 34, 49, 0 };
		gbl_panel_25.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_25.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_25.setLayout(gbl_panel_25);

		lblNewLabel_59 = new JLabel("Change Password");
		lblNewLabel_59.setForeground(new Color(0, 51, 204));
		lblNewLabel_59.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 51, 153)));
		lblNewLabel_59.setFont(new Font("Sitka Heading", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel_59 = new GridBagConstraints();
		gbc_lblNewLabel_59.gridwidth = 3;
		gbc_lblNewLabel_59.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_59.gridx = 1;
		gbc_lblNewLabel_59.gridy = 0;
		panel_25.add(lblNewLabel_59, gbc_lblNewLabel_59);

		lblPassError = new JLabel("");
		lblPassError.setForeground(Color.RED);
		lblPassError.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPassError = new GridBagConstraints();
		gbc_lblPassError.anchor = GridBagConstraints.WEST;
		gbc_lblPassError.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassError.gridx = 2;
		gbc_lblPassError.gridy = 1;
		panel_25.add(lblPassError, gbc_lblPassError);

		lblNewLabel_11 = new JLabel("Your current pass:");
		lblNewLabel_11.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 2;
		panel_25.add(lblNewLabel_11, gbc_lblNewLabel_11);

		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		passwordFieldPass.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		GridBagConstraints gbc_passwordFieldPass = new GridBagConstraints();
		gbc_passwordFieldPass.fill = GridBagConstraints.BOTH;
		gbc_passwordFieldPass.insets = new Insets(0, 0, 5, 5);
		gbc_passwordFieldPass.gridx = 2;
		gbc_passwordFieldPass.gridy = 2;
		panel_25.add(passwordFieldPass, gbc_passwordFieldPass);

		lblNewPassError = new JLabel("");
		lblNewPassError.setForeground(Color.RED);
		lblNewPassError.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewPassError = new GridBagConstraints();
		gbc_lblNewPassError.gridwidth = 3;
		gbc_lblNewPassError.anchor = GridBagConstraints.WEST;
		gbc_lblNewPassError.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewPassError.gridx = 2;
		gbc_lblNewPassError.gridy = 4;
		panel_25.add(lblNewPassError, gbc_lblNewPassError);

		lblNewLabel_13 = new JLabel("New Password:");
		lblNewLabel_13.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 1;
		gbc_lblNewLabel_13.gridy = 5;
		panel_25.add(lblNewLabel_13, gbc_lblNewLabel_13);

		passwordFieldNewPass = new JPasswordField();
		passwordFieldNewPass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		passwordFieldNewPass.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		GridBagConstraints gbc_passwordFieldNewPass = new GridBagConstraints();
		gbc_passwordFieldNewPass.fill = GridBagConstraints.BOTH;
		gbc_passwordFieldNewPass.insets = new Insets(0, 0, 5, 5);
		gbc_passwordFieldNewPass.gridx = 2;
		gbc_passwordFieldNewPass.gridy = 5;
		panel_25.add(passwordFieldNewPass, gbc_passwordFieldNewPass);

		lblRePassError = new JLabel("");
		lblRePassError.setForeground(Color.RED);
		lblRePassError.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		GridBagConstraints gbc_lblRePassError = new GridBagConstraints();
		gbc_lblRePassError.anchor = GridBagConstraints.WEST;
		gbc_lblRePassError.insets = new Insets(0, 0, 5, 5);
		gbc_lblRePassError.gridx = 2;
		gbc_lblRePassError.gridy = 7;
		panel_25.add(lblRePassError, gbc_lblRePassError);

		lblNewLabel_14 = new JLabel("Confirm Password:");
		lblNewLabel_14.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 1;
		gbc_lblNewLabel_14.gridy = 8;
		panel_25.add(lblNewLabel_14, gbc_lblNewLabel_14);

		passwordFieldRePass = new JPasswordField();
		passwordFieldRePass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		passwordFieldRePass.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		GridBagConstraints gbc_passwordFieldRePass = new GridBagConstraints();
		gbc_passwordFieldRePass.fill = GridBagConstraints.BOTH;
		gbc_passwordFieldRePass.insets = new Insets(0, 0, 5, 5);
		gbc_passwordFieldRePass.gridx = 2;
		gbc_passwordFieldRePass.gridy = 8;
		panel_25.add(passwordFieldRePass, gbc_passwordFieldRePass);

		btnChangePassword = new JButton("Change Password", change_pass);
		btnChangePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChangePassword.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChangePasswordActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnChangePassword = new GridBagConstraints();
		gbc_btnChangePassword.gridwidth = 2;
		gbc_btnChangePassword.anchor = GridBagConstraints.WEST;
		gbc_btnChangePassword.insets = new Insets(0, 0, 5, 5);
		gbc_btnChangePassword.gridx = 2;
		gbc_btnChangePassword.gridy = 10;
		panel_25.add(btnChangePassword, gbc_btnChangePassword);

		panelNotification = new JPanel();
		panelNotification.setOpaque(false);
		panelNotification.setBackground(new Color(0, 0, 0, 0));
		panelMain.add(panelNotification, "show_notification");
		GridBagLayout gbl_panelNotification = new GridBagLayout();
		gbl_panelNotification.columnWidths = new int[] { 339, 0, 0 };
		gbl_panelNotification.rowHeights = new int[] { 75, 83, 0 };
		gbl_panelNotification.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelNotification.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panelNotification.setLayout(gbl_panelNotification);

		panel_30 = new JPanel();
		panel_30.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_30 = new GridBagConstraints();
		gbc_panel_30.insets = new Insets(0, 0, 5, 5);
		gbc_panel_30.fill = GridBagConstraints.BOTH;
		gbc_panel_30.gridx = 0;
		gbc_panel_30.gridy = 0;
		panelNotification.add(panel_30, gbc_panel_30);
		panel_30.setLayout(new BoxLayout(panel_30, BoxLayout.X_AXIS));

		panel_32 = new JPanel();

		panel_32.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_32.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_32.setBackground(Color.WHITE);
		panel_30.add(panel_32);
		panel_32.setLayout(new BorderLayout(0, 0));

		lblNewLabel_30 = new JLabel("Your ReLeave");
		lblNewLabel_30.setForeground(new Color(102, 51, 204));
		lblNewLabel_30.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblNewLabel_30
				.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(new Color(0, 51, 204))));
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_32.add(lblNewLabel_30, BorderLayout.CENTER);

		panelNotifiMain = new JPanel();
		panelRequestLeave.setOpaque(false);
		panelRequestLeave.setBackground(new Color(0, 0, 0, 0));
		GridBagConstraints gbc_panelNotifiMain = new GridBagConstraints();
		gbc_panelNotifiMain.gridheight = 2;
		gbc_panelNotifiMain.fill = GridBagConstraints.BOTH;
		gbc_panelNotifiMain.gridx = 1;
		gbc_panelNotifiMain.gridy = 0;
		panelNotification.add(panelNotifiMain, gbc_panelNotifiMain);
		panelNotifiMain.setLayout(new CardLayout(0, 0));

		panel_35 = new JPanel();
		panel_35.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 153, 204), new Color(51, 51, 153))));
		panel_35.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_35.setBackground(Color.WHITE);
		panelNotifiMain.add(panel_35, "name_239294053270100");
		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 1;
		panelNotification.add(scrollPane_2, gbc_scrollPane_2);
		borderlaoutpanel
				.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(new Color(0, 102, 204), 2)));
		borderlaoutpanel.setBackground(Color.WHITE);
		scrollPane_2.setViewportView(borderlaoutpanel);
		borderlaoutpanel.setLayout(new BorderLayout(0, 0));

		borderlaoutpanel.add(columnpanel, BorderLayout.NORTH);
		columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
		columnpanel.setBackground(Color.gray);

		panelRELeave = new JPanel();
		panelRELeave.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRELeave.setBackground(Color.WHITE);
		panelNotifiMain.add(panelRELeave, "leave");
		panelRELeave.setLayout(new BorderLayout(0, 0));

		panel_43 = new JPanel();
		panel_43.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_43.setBackground(Color.WHITE);
		panelRELeave.add(panel_43, BorderLayout.NORTH);
		panel_43.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNewLabel_49 = new JLabel("Request Leave");
		lblNewLabel_49.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_49.setForeground(new Color(0, 51, 204));
		lblNewLabel_49.setFont(new Font("Sitka Text", Font.BOLD, 35));
		panel_43.add(lblNewLabel_49);

		panel_44 = new JPanel();
		panel_44.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_44.setBackground(Color.WHITE);
		panelRELeave.add(panel_44);
		GridBagLayout gbl_panel_44 = new GridBagLayout();
		gbl_panel_44.columnWidths = new int[] { 70, 120, 135, 43, 304, 0, 0, 0 };
		gbl_panel_44.rowHeights = new int[] { 0, 39, 30, 35, 28, 38, 28, 37, 29, 35, 32, 31, 28, 34, 0, 0 };
		gbl_panel_44.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_44.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		panel_44.setLayout(gbl_panel_44);

		lblNewLabel_43 = new JLabel("From Date:");
		lblNewLabel_43.setFont(new Font("Sitka Text", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_43 = new GridBagConstraints();
		gbc_lblNewLabel_43.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_43.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_43.gridx = 2;
		gbc_lblNewLabel_43.gridy = 1;
		panel_44.add(lblNewLabel_43, gbc_lblNewLabel_43);

		textFieldReFrom = new JTextField();
		textFieldReFrom.setBorder(null);
		textFieldReFrom.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		textFieldReFrom.setEditable(false);
		textFieldReFrom.setFocusable(false);
		textFieldReFrom.setColumns(10);
		GridBagConstraints gbc_textFieldReFrom = new GridBagConstraints();
		gbc_textFieldReFrom.fill = GridBagConstraints.BOTH;
		gbc_textFieldReFrom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldReFrom.gridx = 4;
		gbc_textFieldReFrom.gridy = 1;
		panel_44.add(textFieldReFrom, gbc_textFieldReFrom);

		lblNewLabel_44 = new JLabel("To Date:");
		lblNewLabel_44.setFont(new Font("Sitka Text", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_44 = new GridBagConstraints();
		gbc_lblNewLabel_44.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_44.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_44.gridx = 2;
		gbc_lblNewLabel_44.gridy = 3;
		panel_44.add(lblNewLabel_44, gbc_lblNewLabel_44);

		textFieldReTo = new JTextField();
		textFieldReTo.setBorder(null);
		textFieldReTo.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		textFieldReTo.setEditable(false);
		textFieldReTo.setFocusable(false);
		textFieldReTo.setColumns(10);
		GridBagConstraints gbc_textFieldReTo = new GridBagConstraints();
		gbc_textFieldReTo.fill = GridBagConstraints.BOTH;
		gbc_textFieldReTo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldReTo.gridx = 4;
		gbc_textFieldReTo.gridy = 3;
		panel_44.add(textFieldReTo, gbc_textFieldReTo);

		lblNewLabel_52 = new JLabel("Actual Total Days: ");
		lblNewLabel_52.setFont(new Font("Sitka Text", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_52 = new GridBagConstraints();
		gbc_lblNewLabel_52.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_52.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_52.gridx = 2;
		gbc_lblNewLabel_52.gridy = 5;
		panel_44.add(lblNewLabel_52, gbc_lblNewLabel_52);

		textFieldTotalDate = new JTextField();
		textFieldTotalDate.setBorder(null);
		textFieldTotalDate.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		textFieldTotalDate.setFocusable(false);
		textFieldTotalDate.setEditable(false);
		textFieldTotalDate.setColumns(10);
		GridBagConstraints gbc_textFieldTotalDate = new GridBagConstraints();
		gbc_textFieldTotalDate.fill = GridBagConstraints.BOTH;
		gbc_textFieldTotalDate.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTotalDate.gridx = 4;
		gbc_textFieldTotalDate.gridy = 5;
		panel_44.add(textFieldTotalDate, gbc_textFieldTotalDate);

		lblNewLabel_45 = new JLabel("Leave Type:");
		lblNewLabel_45.setFont(new Font("Sitka Text", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_45 = new GridBagConstraints();
		gbc_lblNewLabel_45.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_45.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_45.gridx = 2;
		gbc_lblNewLabel_45.gridy = 7;
		panel_44.add(lblNewLabel_45, gbc_lblNewLabel_45);

		textFieldReType = new JTextField();
		textFieldReType.setBorder(null);
		textFieldReType.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		textFieldReType.setEditable(false);
		textFieldReType.setFocusable(false);
		textFieldReType.setColumns(10);
		GridBagConstraints gbc_textFieldReType = new GridBagConstraints();
		gbc_textFieldReType.fill = GridBagConstraints.BOTH;
		gbc_textFieldReType.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldReType.gridx = 4;
		gbc_textFieldReType.gridy = 7;
		panel_44.add(textFieldReType, gbc_textFieldReType);

		lblNewLabel_46 = new JLabel("Admin:");
		lblNewLabel_46.setFont(new Font("Sitka Text", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_46 = new GridBagConstraints();
		gbc_lblNewLabel_46.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_46.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_46.gridx = 2;
		gbc_lblNewLabel_46.gridy = 9;
		panel_44.add(lblNewLabel_46, gbc_lblNewLabel_46);

		textFieldReAdmin = new JTextField();
		textFieldReAdmin.setBorder(null);
		textFieldReAdmin.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		textFieldReAdmin.setEditable(false);
		textFieldReAdmin.setFocusable(false);
		textFieldReAdmin.setColumns(10);
		GridBagConstraints gbc_textFieldReAdmin = new GridBagConstraints();
		gbc_textFieldReAdmin.fill = GridBagConstraints.BOTH;
		gbc_textFieldReAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldReAdmin.gridx = 4;
		gbc_textFieldReAdmin.gridy = 9;
		panel_44.add(textFieldReAdmin, gbc_textFieldReAdmin);

		lblNewLabel_60 = new JLabel("Date limit:");
		lblNewLabel_60.setFont(new Font("Sitka Text", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_60 = new GridBagConstraints();
		gbc_lblNewLabel_60.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_60.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_60.gridx = 2;
		gbc_lblNewLabel_60.gridy = 11;
		panel_44.add(lblNewLabel_60, gbc_lblNewLabel_60);

		textFieldDateLimit = new JTextField();
		textFieldDateLimit.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		textFieldDateLimit.setFocusable(false);
		textFieldDateLimit.setEditable(false);
		textFieldDateLimit.setColumns(10);
		textFieldDateLimit.setBorder(null);
		GridBagConstraints gbc_textFieldDateLimit = new GridBagConstraints();
		gbc_textFieldDateLimit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDateLimit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDateLimit.gridx = 4;
		gbc_textFieldDateLimit.gridy = 11;
		panel_44.add(textFieldDateLimit, gbc_textFieldDateLimit);

		lblNewLabel_53 = new JLabel("Status:");
		lblNewLabel_53.setFont(new Font("Sitka Text", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_53 = new GridBagConstraints();
		gbc_lblNewLabel_53.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_53.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_53.gridx = 2;
		gbc_lblNewLabel_53.gridy = 13;
		panel_44.add(lblNewLabel_53, gbc_lblNewLabel_53);

		textFieldStatus = new JTextField();
		textFieldStatus.setBorder(null);
		textFieldStatus.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		textFieldStatus.setFocusable(false);
		textFieldStatus.setEditable(false);
		textFieldStatus.setColumns(10);
		GridBagConstraints gbc_textFieldStatus = new GridBagConstraints();
		gbc_textFieldStatus.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldStatus.fill = GridBagConstraints.BOTH;
		gbc_textFieldStatus.gridx = 4;
		gbc_textFieldStatus.gridy = 13;
		panel_44.add(textFieldStatus, gbc_textFieldStatus);
		lblNewLabel_30.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				columnpanel.removeAll();
				loadRequestLeave(columnpanel);
				panel_32.setBackground(Color.GRAY);

			}

			public void mouseEntered(MouseEvent e) {
				panel_32.setBackground(Color.GRAY);
			}

			public void mouseExited(MouseEvent e) {
				panel_32.setBackground(Color.white);
			}

		});
		panelMenu = new JPanel();
		panelMenu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMenu.setBackground(Color.WHITE);
		contentPane.add(panelMenu, BorderLayout.WEST);
		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[] { 123, 0 };
		gbl_panelMenu.rowHeights = new int[] { 0, 64, 17, 68, 17, 66, 17, 65, 17, 67, 17, 65, 17, 66, 0, 17, 0 };
		gbl_panelMenu.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelMenu.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		panelMenu.setLayout(gbl_panelMenu);

		btnCreateRequest = new JButton("");
		btnCreateRequest.setBorder(null);
		btnCreateRequest.setBackground(Color.WHITE);
		btnCreateRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateRequestActionPerformed(e);
			}
		});
		btnCreateRequest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnCreateRequest.setFocusPainted(false);
		btnCreateRequest.setIcon(new ImageIcon(new ImageIcon(ClientAdminHr.class.getResource("/Images/dac_create.png"))
				.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnCreateRequest = new GridBagConstraints();
		gbc_btnCreateRequest.anchor = GridBagConstraints.NORTH;
		gbc_btnCreateRequest.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateRequest.gridx = 0;
		gbc_btnCreateRequest.gridy = 1;
		panelMenu.add(btnCreateRequest, gbc_btnCreateRequest);

		lblNewLabel = new JLabel("Create Request");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panelMenu.add(lblNewLabel, gbc_lblNewLabel);

		btnCalendar = new JButton("");
		btnCalendar.setBorder(null);
		btnCalendar.setBackground(Color.WHITE);
		btnCalendar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCalendarActionPerformed(e);
			}
		});

		btnNotification = new JButton("");
		btnNotification.setBorder(null);
		btnNotification.setBackground(Color.WHITE);
		btnNotification.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNotification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateRequest_1ActionPerformed(e);
				columnpanel.removeAll();
				columnpanel.revalidate();
				loadRequestLeave(columnpanel);
			}
		});
		btnNotification.setIcon(new ImageIcon(new ImageIcon(ClientAdminHr.class.getResource("/Images/dac_notifi.png"))
				.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
		btnNotification.setFocusPainted(false);
		GridBagConstraints gbc_btnNotification = new GridBagConstraints();
		gbc_btnNotification.fill = GridBagConstraints.VERTICAL;
		gbc_btnNotification.insets = new Insets(0, 0, 5, 0);
		gbc_btnNotification.gridx = 0;
		gbc_btnNotification.gridy = 3;
		panelMenu.add(btnNotification, gbc_btnNotification);

		lblNewLabel_1 = new JLabel("Notification");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		panelMenu.add(lblNewLabel_1, gbc_lblNewLabel_1);

		btnCalendar.setFocusPainted(false);
		btnCalendar.setIcon(new ImageIcon(new ImageIcon(ClientAdminHr.class.getResource("/Images/dac_calendar.png"))
				.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnCalendar = new GridBagConstraints();
		gbc_btnCalendar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCalendar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalendar.gridx = 0;
		gbc_btnCalendar.gridy = 5;
		panelMenu.add(btnCalendar, gbc_btnCalendar);

		lblNewLabel_48 = new JLabel("Calendar");
		lblNewLabel_48.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_48.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_48 = new GridBagConstraints();
		gbc_lblNewLabel_48.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_48.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_48.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_48.gridx = 0;
		gbc_lblNewLabel_48.gridy = 6;
		panelMenu.add(lblNewLabel_48, gbc_lblNewLabel_48);

		btnMyProfile = new JButton("");
		btnMyProfile.setBorder(null);
		btnMyProfile.setBackground(Color.WHITE);
		btnMyProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMyProfileActionPerformed(e);
			}
		});
		btnMyProfile.setFocusPainted(false);
		btnMyProfile.setIcon(new ImageIcon(new ImageIcon(ClientAdminHr.class.getResource("/Images/dac_user.png"))
				.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnMyProfile = new GridBagConstraints();
		gbc_btnMyProfile.anchor = GridBagConstraints.NORTH;
		gbc_btnMyProfile.insets = new Insets(0, 0, 5, 0);
		gbc_btnMyProfile.gridx = 0;
		gbc_btnMyProfile.gridy = 7;
		panelMenu.add(btnMyProfile, gbc_btnMyProfile);

		lblNewLabel_2 = new JLabel("My Profile");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 8;
		panelMenu.add(lblNewLabel_2, gbc_lblNewLabel_2);

		btnChangePass = new JButton("");
		btnChangePass.setBorder(null);
		btnChangePass.setBackground(Color.WHITE);
		btnChangePass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChangePassActionPerformed(e);
			}
		});
		btnChangePass.setFocusPainted(false);
		btnChangePass.setIcon(new ImageIcon(new ImageIcon(ClientAdminHr.class.getResource("/Images/dac_password.png"))
				.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnChangePass = new GridBagConstraints();
		gbc_btnChangePass.anchor = GridBagConstraints.NORTH;
		gbc_btnChangePass.insets = new Insets(0, 0, 5, 0);
		gbc_btnChangePass.gridx = 0;
		gbc_btnChangePass.gridy = 9;
		panelMenu.add(btnChangePass, gbc_btnChangePass);

		lblNewLabel_3 = new JLabel("Change Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 10;
		panelMenu.add(lblNewLabel_3, gbc_lblNewLabel_3);

		btnLogOut = new JButton("");
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogOutActionPerformed(e);
			}
		});

		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackActionPerformed(e);
			}
		});
		btnBack.setFocusPainted(false);
		btnBack.setBorder(null);
		btnBack.setBackground(Color.WHITE);
		btnBack.setIcon(new ImageIcon(new ImageIcon(ClientAdminHr.class.getResource("/Images/back.png")).getImage()
				.getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 11;
		panelMenu.add(btnBack, gbc_btnBack);

		lblNewLabel_51 = new JLabel("Back");
		lblNewLabel_51.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_51.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_51 = new GridBagConstraints();
		gbc_lblNewLabel_51.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_51.gridx = 0;
		gbc_lblNewLabel_51.gridy = 12;
		panelMenu.add(lblNewLabel_51, gbc_lblNewLabel_51);
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setIcon(new ImageIcon(new ImageIcon(ClientAdminHr.class.getResource("/Images/logout.png")).getImage()
				.getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogOut.gridx = 0;
		gbc_btnLogOut.gridy = 13;
		panelMenu.add(btnLogOut, gbc_btnLogOut);

		lblNewLabel_4 = new JLabel("Log Out");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 14;
		panelMenu.add(lblNewLabel_4, gbc_lblNewLabel_4);

		GradientPanel panelLogo = new GradientPanel(Color.white, new Color(0, 160, 255), 3);
		panelLogo.setBackground(Color.WHITE);
		panelLogo.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 204, 204)));
		contentPane.add(panelLogo, BorderLayout.NORTH);
		panelLogo.setLayout(new BorderLayout(0, 0));

		lblNewLabel_5 = new JLabel("Employee Client");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Sitka Heading", Font.BOLD, 50));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panelLogo.add(lblNewLabel_5, BorderLayout.CENTER);
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooserFrom.getDateEditor();
		editor.setEditable(false);
		editor.setFocusable(false);
		JTextFieldDateEditor editor1 = (JTextFieldDateEditor) dateChooserTo.getDateEditor();
		editor1.setEditable(false);
		editor1.setFocusable(false);

		dateChooserFrom.getJCalendar().setPreferredSize(new Dimension(450, 200));
		dateChooserTo.getJCalendar().setPreferredSize(new Dimension(450, 200));
		dateChooserFrom.getJCalendar().setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateChooserTo.getJCalendar().setFont(new Font("Tahoma", Font.PLAIN, 12));
		calendar.getDayChooser().setFont(new Font("Tahoma", Font.PLAIN, 15));

	}

	public ClientAdminHr(Employee emp) {
		this();
		this.employee = emp;
		loadProfile(emp);
		lblEmpName.setText(emp.getFullname());
		DepartmentBao bao = new DepartmentBao();
		lblDept.setText(bao.getdep(employee.getIddep()).getNamedep());
		calendar.getMonthChooser().addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertChanged2(evt);
		});

		calendar.getYearChooser().addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertChanged2(evt);
		});

		calendar.getDayChooser().addPropertyChangeListener(

				(PropertyChangeEvent evt) -> {
					dateChooserPropertChanged2(evt);
				});
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChangePasswordActionPerformed(e);
			}
		});
		comboBoxDayType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getID() == ItemEvent.ITEM_STATE_CHANGED) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						JComboBox<String> cb = (JComboBox<String>) e.getSource();
						String newSelection = (String) cb.getSelectedItem();
						if (newSelection.equals("Half Day")) {
							lblShift.setEnabled(true);
							comboBox.setEnabled(true);
						} else {
							lblShift.setEnabled(false);
							comboBox.setEnabled(false);
						}
					}
				}
			}
		});

		btnCreateRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateRequestActionPerformed(e);
			}
		});

		dateChooserFrom.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertChanged(evt);
		});
		dateChooserFrom.getJCalendar().addPropertyChangeListener((PropertyChangeEvent evt) -> {
			loadDate(dateChooserFrom);
		});
		dateChooserTo.addPropertyChangeListener((PropertyChangeEvent evt) -> {
			dateChooserPropertChanged(evt);
		});
		dateChooserTo.getJCalendar().addPropertyChangeListener((PropertyChangeEvent evt) -> {
			loadDate(dateChooserTo);
		});

		loadAdmin(employee);

	}

	protected void btnLogOut_1ActionPerformed(ActionEvent e) {
		ChooseType chooseType = new ChooseType(employee);
		this.setVisible(false);
		chooseType.setVisible(true);
	}

	public void loadProfile(Employee employee) {
		textFieldFullname.setText(employee.getFullname());
		textFieldDob.setText(employee.getDob().toString());
		textFieldGender.setText(employee.getGender());

		DepartmentBao bao = new DepartmentBao();
		textFieldDepartment.setText(bao.getdep(employee.getIddep()).getNamedep());

		textFieldAddress.setText(employee.getAddress());
		textFieldPhone.setText(employee.getPhone());
		textFieldEmail.setText(employee.getEmail());

		textFieldOD.setText(employee.getOnboarddate().toString());
		textFieldAL.setText(String.valueOf(employee.getAnnualleave()));
		textFieldUL.setText(String.valueOf(employee.getUnpaidleave()));
		textFieldSL.setText(String.valueOf(employee.getSickleave()));

		RelativesBao relativesBao = new RelativesBao();
		Relatives relatives = relativesBao.getRelatives(employee.getIdemp());
		textFieldFullnameRE.setText(relatives.getFullname());
		textFieldRelation.setText(relatives.getRelationship());
		textFieldPhoneRE.setText(relatives.getPhone());
	}

	protected void btnChangePassActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panelMain.getLayout();
		card.show(panelMain, "change_pass");
		passwordFieldPass.setText("");
		passwordFieldNewPass.setText("");
		passwordFieldRePass.setText("");
		lblPassError.setText("");
		lblNewPassError.setText("");
		lblRePassError.setText("");

	}

	protected void btnMyProfileActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panelMain.getLayout();
		card.show(panelMain, "my_profile");
	}

	protected void btnCreateRequestActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panelMain.getLayout();
		dateChooserFrom.setCalendar(null);
		dateChooserTo.setCalendar(null);
		DefaultComboBoxModel<Employee> listModel = (DefaultComboBoxModel) listAdmin.getModel();
		listModel.removeAllElements();
		loadAdmin(employee);
		card.show(panelMain, "request_leave");
	}

	protected void btnCalendarActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panelMain.getLayout();
		card.show(panelMain, "calendar");
	}

	protected void btnCreateRequest_1ActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panelMain.getLayout();
		card.show(panelMain, "show_notification");
		CardLayout card2 = (CardLayout) panelNotifiMain.getLayout();
		card2.show(panelNotifiMain, "name_239294053270100");
	}

	protected void btnLogOutActionPerformed(ActionEvent e) {
		if (JOptionPane.showConfirmDialog(null, "Are You Sure Logout?", "",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			Main main = new Main();
			main.setVisible(true);
			this.setVisible(false);
		}
	}
	// change password code

	public void checkPassword(String password, String confirm) {
		if (helper.Validation.MessErrorInputPass(password).equals("")) {
			lblPassError.setText("");
		}
		if (!password.equals(confirm)) {
			lblRePassError.setText("Password not match!");
			lblNewPassError.setText(helper.Validation.MessErrorInputPass(password));
		} else {
			lblNewPassError.setText(helper.Validation.MessErrorInputPass(password));
			lblRePassError.setText("");
		}
	}

	private boolean nullUserPass(String text, String error, JLabel label) {
		if (!(text.equals(""))) {
			return true;
		} else {
			label.setText(error);
			return false;
		}
	}

	protected void btnChangePasswordActionPerformed(ActionEvent e) {
		lblPassError.setText("");
		lblRePassError.setText("");
		lblNewPassError.setText("");
		var pass = String.valueOf(passwordFieldPass.getPassword());
		var newPass = String.valueOf(passwordFieldNewPass.getPassword());
		var rePass = String.valueOf(passwordFieldRePass.getPassword());

		var check = nullUserPass(pass, "Please enter pass", lblPassError);
		var check1 = nullUserPass(newPass, "Please enter new pass", lblNewPassError);

		if (check) {
			if (BCrypt.checkpw(pass, employee.getPass())) {
				if (check1) {
					checkPassword(newPass, rePass);
					if (lblPassError.getText().equals("") && lblRePassError.getText().equals("")
							&& lblNewPassError.getText().equals("")) {
						if (JOptionPane.showConfirmDialog(null, "Are You Sure Change Password?", "",
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							empBao = new EmployeeBao();
							var hashpass = BCrypt.hashpw(newPass, BCrypt.gensalt());
							var excute = empBao.updatePassById(hashpass, employee.getIdemp());
							if (excute != 0) {
								JOptionPane.showMessageDialog(null, "Change Success");
								CardLayout card = (CardLayout) panelMain.getLayout();
								card.show(panelMain, "my_profile");

							} else {
								JOptionPane.showMessageDialog(null, "Change Error");
							}
						}
					}
				}
			} else {
				lblPassError.setText("Wrong Password");
			}
		}

	}

	// request leave code

	public void loadComboDay() {
		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>();
		boxModel.addElement("Full Day");
		boxModel.addElement("Half Day");
		comboBoxDayType.setModel(boxModel);
	}

	public void loadComboShift() {

		try {
			DefaultComboBoxModel<Shift> model = new DefaultComboBoxModel<Shift>();
			AttendancerecordBao attendancerecordBao = new AttendancerecordBao();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			ShiftBao bao = new ShiftBao();
			Date xDate = format.parse(format.format(dateChooserFrom.getDate()));
			int shift = attendancerecordBao.getshift(employee.getIdemp(), new java.sql.Date(xDate.getTime()));

			if (dateChooserFrom.getDate() != null && dateChooserTo.getDate() != null) {
				if (format.format(dateChooserFrom.getDate()).compareTo(format.format(dateChooserTo.getDate())) == 0
						&& shift < 10) {

					bao.getListHalfShift(shift).forEach(x -> model.addElement(x));

				} else if (format.format(dateChooserFrom.getDate())
						.compareTo(format.format(dateChooserTo.getDate())) == 0 && shift > 10) {
					bao.getListShift().forEach(x -> {
						if (x.getIdShift() == shift) {
							model.addElement(x);
						}
					});
				}

			}
			comboBox.setModel(model);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadAdmin(Employee employee) {
		EmployeeBao bao = new EmployeeBao();
		bao.getADO().forEach(ado -> {
			if (ado.getIdemp()!=employee.getIdemp()) {
				listAdmin.addItem(ado);
			}
		});
	}

	protected void btnSubmitActionPerformed(ActionEvent e) {
		lblFromError.setText("");
		lblToError.setText("");
		lblAdminError.setText("");
		var al = 0.0;
		var ul = 0.0;
		var sl = 0.0;
		check = true;
		if (checkDateNull()) {
			if (checkDate()) {
				Employee admin = checkAdmin();
				boolean checkDu = checkDuplicate();

				double total = checkTotalDate();
				int xShift = 0;

				if (total == 0) {
					total = 0.5;
				}

				if (rdbtnAL.isSelected()) {
					if (employee.getAnnualleave() < total) {
						check = false;
						JOptionPane.showMessageDialog(null, "Your annual leave days are not enough");
					} else {
						al = total;

					}
				}
				if (rdbtnUL.isSelected()) {
					if (employee.getUnpaidleave() < total) {
						check = false;
						JOptionPane.showMessageDialog(null, "Your unpaid leave days are not enough");
					} else {
						ul = total;

					}
				}
				if (rdbtnSL.isSelected()) {
					if (employee.getSickleave() < total) {
						check = false;
						JOptionPane.showMessageDialog(null, "Your sick leave days are not enough");
					} else {
						sl = total;
					}
				}

				if (lblAdminError.getText().equals("") && lblToError.getText().equals("")
						&& lblFromError.getText().equals("") && check && checkDu
						&& lblFromToError.getText().equals("")) {
					RequestleaveBao bao = new RequestleaveBao();
					if (comboBoxDayType.getSelectedItem() != null) {

						if (comboBoxDayType.getSelectedItem().toString().equals("Half Day")) {
							Shift shift = (Shift) comboBox.getSelectedItem();
							xShift = shift.getIdShift();
							if (al > 0) {
								al = 0.5;
							} else if (ul > 0) {
								al = 0.5;
							} else if (sl > 0) {
								al = 0.5;
							}
							if (JOptionPane.showConfirmDialog(null, "Are You Sure Submit?", "",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								Requestleave requestleave = new Requestleave(employee.getIdemp(),
										dateChooserFrom.getDate(), dateChooserTo.getDate(), al, ul, sl,
										admin.getIdemp(), 1, xShift);
								bao.insertReLeave(requestleave);
								columnpanel.removeAll();
								CardLayout card = (CardLayout) panelMain.getLayout();
								card.show(panelMain, "show_notification");
								loadRequestLeave(columnpanel);
								JOptionPane.showMessageDialog(null, "Done");
							}
						} else {
							if (JOptionPane.showConfirmDialog(null, "Are You Sure Submit?", "",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								Requestleave requestleave = new Requestleave(employee.getIdemp(),
										dateChooserFrom.getDate(), dateChooserTo.getDate(), al, ul, sl,
										admin.getIdemp(), 1, 0);
								bao.insertReLeave(requestleave);
								columnpanel.removeAll();
								CardLayout card = (CardLayout) panelMain.getLayout();
								card.show(panelMain, "show_notification");
								loadRequestLeave(columnpanel);

								JOptionPane.showMessageDialog(null, "Done");
							}
						}
					} else {
						if (JOptionPane.showConfirmDialog(null, "Are You Sure Submit?", "",
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							Requestleave requestleave = new Requestleave(employee.getIdemp(), dateChooserFrom.getDate(),
									dateChooserTo.getDate(), al, ul, sl, admin.getIdemp(), 1, 0);
							bao.insertReLeave(requestleave);
							columnpanel.removeAll();
							CardLayout card = (CardLayout) panelMain.getLayout();
							card.show(panelMain, "show_notification");
							loadRequestLeave(columnpanel);
							JOptionPane.showMessageDialog(null, "Done");
						}
					}

				}

			}
		}

	}

	public boolean checkDuplicate() {
		check = true;
		RequestleaveBao bao = new RequestleaveBao();
		List<Requestleave> list = new ArrayList<Requestleave>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		var from = format.format(dateChooserFrom.getDate());
		var to = format.format(dateChooserTo.getDate());
		list = bao.getRLByIdemp(employee.getIdemp());
		if (list != null) {
			list.stream().forEach(x -> {
				try {
					if ((((x.getFromdate().compareTo(format.parse(from)) <= 0)
							&& (x.getTodate().compareTo(format.parse(from)) >= 0))
							|| ((x.getFromdate().compareTo(format.parse(to)) <= 0)
									&& (x.getTodate().compareTo(format.parse(to)) >= 0))
							|| (x.getFromdate().compareTo(format.parse(from)) >= 0)
									&& (x.getFromdate().compareTo(format.parse(to)) <= 0)
							|| (x.getTodate().compareTo(format.parse(from)) <= 0)
									&& (x.getTodate().compareTo(format.parse(to)) >= 0))
							&& (x.getSttrequestleave() != 0 && x.getSendrequesttoadmin() != 5)) {

						check = false;

					}
				} catch (HeadlessException | ParseException e) {
					e.printStackTrace();
				}
			});
		}
		if (from.compareTo(to) == 0) {
			if (bao.reHalfShift(employee.getIdemp(), dateChooserFrom.getDate()) != 0) {
				check = true;
			}
		}

		if (check == false) {
			JOptionPane.showMessageDialog(null, "Your date is duplicated");
		}

		return check;
	}

	public Employee checkAdmin() {
		Employee employee = null;
		if (listAdmin.getSelectedIndex() == -1) {
			lblAdminError.setText("Choose Admin");
		} else {
			employee = (Employee) listAdmin.getSelectedItem();
		}
		return employee;
	}

	private void dateChooserPropertChanged(PropertyChangeEvent evt) {

		if ("calendar".equals(evt.getPropertyName()) || "date".equals(evt.getPropertyName())) {

			checkFromTo();
		}

	}

	public void checkFromTo() {

		Calendar calendar1 = null, calendar2 = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		AttendancerecordBao attendancerecordBao = new AttendancerecordBao();
		RequestleaveBao bao = new RequestleaveBao();
		ShiftBao shiftBao = new ShiftBao();

		if (dateChooserFrom.getDate() != null && dateChooserTo.getDate() != null) {
			if (dateFormat.format(dateChooserFrom.getDate())
					.compareTo(dateFormat.format(dateChooserTo.getDate())) == 0) {
				var note = bao.reHalfShift(employee.getIdemp(), dateChooserFrom.getDate());
				comboBoxDayType.setEnabled(true);
				lblDayType.setEnabled(true);
				DefaultComboBoxModel<String> boxModel = (DefaultComboBoxModel) comboBoxDayType.getModel();
				boxModel.removeAllElements();
				DefaultComboBoxModel<Shift> boxModel4 = (DefaultComboBoxModel) comboBox.getModel();
				boxModel4.removeAllElements();
				loadComboDay();
				loadComboShift();
				if (note > 0) {
					DefaultComboBoxModel<String> boxModel2 = (DefaultComboBoxModel) comboBoxDayType.getModel();
					boxModel2.removeElement("Full Day");
				} else if (note < 0) {
					DefaultComboBoxModel<String> boxModel2 = (DefaultComboBoxModel) comboBoxDayType.getModel();
					boxModel2.removeAllElements();
					DefaultComboBoxModel<Shift> boxModel5 = (DefaultComboBoxModel) comboBox.getModel();
					boxModel5.removeAllElements();
					comboBoxDayType.setEnabled(false);
					lblDayType.setEnabled(false);
					comboBox.setEnabled(false);
					lblShift.setEnabled(false);
				}

			} else {
				comboBoxDayType.setEnabled(false);
				lblDayType.setEnabled(false);
				comboBox.setEnabled(false);
				lblShift.setEnabled(false);
				DefaultComboBoxModel<String> boxModel = (DefaultComboBoxModel) comboBoxDayType.getModel();
				boxModel.removeAllElements();
				DefaultComboBoxModel<String> boxModel2 = (DefaultComboBoxModel) comboBox.getModel();
				boxModel2.removeAllElements();

			}

		} else {
			comboBoxDayType.setEnabled(false);
			lblDayType.setEnabled(false);
			comboBox.setEnabled(false);
			lblShift.setEnabled(false);
			DefaultComboBoxModel<String> boxModel = (DefaultComboBoxModel) comboBoxDayType.getModel();
			boxModel.removeAllElements();
			DefaultComboBoxModel<String> boxModel2 = (DefaultComboBoxModel) comboBox.getModel();
			boxModel2.removeAllElements();
		}

	}

	public double checkTotalDate() {
		var dateFrom = dateChooserFrom.getDate();
		var dateTo = dateChooserTo.getDate();
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		AttendancerecordBao attendancerecordBao = new AttendancerecordBao();

		attendancerecordBao.countDay(dateFrom, dateTo, employee.getIdemp());

		return attendancerecordBao.countDay(dateFrom, dateTo, employee.getIdemp());
	}

	public boolean checkDate() {
		boolean checkDa = true;
		long millis = System.currentTimeMillis();
		Date today = new Date(millis);

		if (dateChooserFrom.getDate().after(dateChooserTo.getDate())) {
			lblToError.setText("Date to must be after date from");
			checkDa = false;
		}

		if (checkDa) {
			lblToError.setText("");
			lblFromError.setText("");
		}
		return checkDa;
	}

	public boolean checkDateNull() {
		boolean checkNull = true;
		if (dateChooserFrom.getDate() == null) {
			lblFromError.setText("Must enter date");
			checkNull = false;
		} else {
			lblFromError.setText("");
		}
		if (dateChooserTo.getDate() == null) {
			lblToError.setText("Must enter date");
			checkNull = false;
		} else {
			lblToError.setText("");
		}
		return checkNull;
	}
	// change shift code

	public void loadDate(JDateChooser chooser) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int offset = cal.get(Calendar.DAY_OF_WEEK);
		int mon = chooser.getJCalendar().getMonthChooser().getMonth() + 1;
		int yr = chooser.getJCalendar().getYearChooser().getYear();
		Calendar calendar2 = Calendar.getInstance();
		long millis = System.currentTimeMillis();
		java.sql.Date today = new java.sql.Date(millis);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		List<Date> list = new ArrayList<Date>();

		JPanel jpanel = chooser.getJCalendar().getDayChooser().getDayPanel();

		Component component[] = jpanel.getComponents();

		AttendancerecordBao attendancerecordBao = new AttendancerecordBao();
		calendar2.setTime(today);
		calendar2.add(Calendar.DAY_OF_MONTH, -15);
		chooser.getJCalendar().getDayChooser().setMinSelectableDate(calendar2.getTime());
		chooser.getJCalendar().getDayChooser().setMaxSelectableDate(attendancerecordBao.lastDate());

		attendancerecordBao.getDate(employee.getIdemp()).stream().forEach(x -> {
			if (mon == x.getMonth() && yr == x.getYear()
					&& (x.getDate().toString()).compareTo(dateFormat.format(calendar2.getTime())) >= 0) {

				int ctr = 0;
				for (int i = 7; i < 14; i++) {
					if (component[i].isVisible() == false) {
						ctr++;
					}
				}

				Color co = null;
				switch (x.getIdShift()) {
				case 0: {
					co = Color.gray;
					component[x.getDay() + offset + ctr].setEnabled(false);
					break;
				}
				case 1: {
					co = Color.magenta;
					break;
				}
				case 2: {
					co = Color.green;
					break;
				}
				case 3: {
					co = Color.cyan;
					break;
				}
				case 4: {
					co = Color.yellow;
					break;
				}
				default:
					co = Color.pink;

					break;
				}
				component[x.getDay() + offset + ctr].setBackground(co);
			}
		});
	}

	// calendar code

	private void dateChooserPropertChanged2(PropertyChangeEvent evt) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int offset = cal.get(Calendar.DAY_OF_WEEK);
		int mon = calendar.getMonthChooser().getMonth() + 1;
		int yr = calendar.getYearChooser().getYear();
		Calendar calendar2 = Calendar.getInstance();
		long millis = System.currentTimeMillis();
		java.sql.Date today = new java.sql.Date(millis);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		AttendancerecordBao attendancerecordBao = new AttendancerecordBao();
		List<Date> list = new ArrayList<Date>();

		JPanel jpanel = calendar.getDayChooser().getDayPanel();

		calendar.getDayChooser().setMaxSelectableDate(attendancerecordBao.lastDate());

		Component component[] = jpanel.getComponents();

		attendancerecordBao.getDate(employee.getIdemp()).stream().forEach(x -> {
			if (mon == x.getMonth() && yr == x.getYear()) {

				int ctr = 0;
				for (int i = 7; i < 14; i++) {
					if (component[i].isVisible() == false) {
						ctr++;
					}
				}

				Color co = null;
				switch (x.getIdShift()) {
				case 0: {
					co = Color.gray;
					break;
				}
				case 1: {
					co = Color.magenta;
					break;
				}
				case 2: {
					co = Color.green;
					break;
				}
				case 3: {
					co = Color.cyan;
					break;
				}
				case 4: {
					co = Color.yellow;
					break;
				}
				default:
					co = Color.pink;
					break;
				}

				component[x.getDay() + offset + ctr].setBackground(co);

			}
		});
		Date xDate;
		try {
			xDate = dateFormat.parse(dateFormat.format(calendar.getDate()));
			int shift = attendancerecordBao.getshift(employee.getIdemp(), new java.sql.Date(xDate.getTime()));
			ShiftBao bao = new ShiftBao();
			bao.getListShift().stream().forEach(x -> {
				if (x.getIdShift() == shift) {
					textFieldWorkTimeInfo.setText("" + x.getTimein());
					textFieldTo.setText("" + x.getTimeout());

				}
			});

			textFieldDateInfo.setText(dateFormat.format(calendar.getDate()));
			textFieldShiftInfo.setText(String.valueOf(shift));
			btnGoToRQL.setEnabled(true);
			if ((dateFormat.format(calendar.getDate())).compareTo(today.toString()) == 0 || shift > 10) {
				textFieldShiftInfo.setText(String.valueOf(shift));
				btnGoToRQL.setEnabled(false);

			}

			if (shift == 0 || (dateFormat.format(calendar.getDate())).compareTo(today.toString()) < 0) {
				if (shift == 0) {
					textFieldShiftInfo.setText("Day off");
				} else {
					textFieldShiftInfo.setText(String.valueOf(shift));
				}

				textFieldWorkTimeInfo.setText("");
				textFieldTo.setText("");
				btnGoToRQL.setEnabled(false);

			}

		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	protected void btnGoToRQLActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panelMain.getLayout();
		card.show(panelMain, "request_leave");
		dateChooserFrom.setDate(calendar.getDate());

	}

	// show notification

	public void loadPressed(JPanel jPanel) {
		Component components[] = jPanel.getComponents();

		for (Component component : components) {
			if (component instanceof JPanel) {
				component.setBackground(Color.white);
				component.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						component.setBackground(Color.gray);
						for (Component component2 : components) {
							if (component2 instanceof JPanel) {
								if (component2 != component) {
									component2.setBackground(Color.white);
									component2.addMouseListener(new MouseAdapter() {
										public void mouseExited(MouseEvent e) {
											component2.setBackground(Color.white);
										}
									});
								} else {
									component2.addMouseListener(new MouseAdapter() {
										public void mouseExited(MouseEvent e) {
											component2.setBackground(Color.gray);
										}
									});
								}
							}
						}
					}

				});
			}
		}
	}

	public void loadRequestLeave(JPanel jPanel) {
		CardLayout card = (CardLayout) panelNotifiMain.getLayout();
		card.show(panelNotifiMain, "name_239294053270100");
		jPanel.removeAll();
		RequestleaveBao bao = new RequestleaveBao();
		EmployeeBao bao2 = new EmployeeBao();
		if (bao.getRLByIdemp(employee.getIdemp()).size() != jPanel.getComponents().length) {

			bao.getRLByIdemp(employee.getIdemp()).stream().forEach(x -> {

				JPanel rowPanel = new JPanel();
				rowPanel.setPreferredSize(new Dimension(150, 100));
				jPanel.add(rowPanel);
				rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.Y_AXIS));
				rowPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				rowPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				JPanel a;
				JPanel b;
				JLabel c;
				JLabel d;

				a = new JPanel();
				a.setOpaque(true);
				a.setBackground(new Color(0, 0, 0, 0));
				rowPanel.add(a);

				a.setLayout(new BorderLayout(0, 0));

				c = new JLabel("From Date: " + x.getFromdate());
				a.add(c, BorderLayout.CENTER);

				b = new JPanel();
				b.setOpaque(true);
				b.setBackground(new Color(0, 0, 0, 0));
				rowPanel.add(b);
				b.setLayout(new BorderLayout(0, 0));

				d = new JLabel("To Date: " + x.getTodate());
				b.add(d, BorderLayout.CENTER);

				rowPanel.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						CardLayout card = (CardLayout) panelNotifiMain.getLayout();
						card.show(panelNotifiMain, "leave");
						textFieldReFrom.setText(x.getFromdate().toString());
						textFieldReTo.setText(x.getTodate().toString());
						if (x.getAnnualleave() != 0) {
							textFieldReType.setText("Annual Leave");
							textFieldTotalDate.setText(String.valueOf(x.getAnnualleave()));
						} else if (x.getSickleave() != 0) {
							textFieldReType.setText("Sick Leave");
							textFieldTotalDate.setText(String.valueOf(x.getSickleave()));
						} else if (x.getUnpaidleave() != 0) {
							textFieldReType.setText("Unpaid Leave");
							textFieldTotalDate.setText(String.valueOf(x.getUnpaidleave()));
						}
						textFieldDateLimit.setText(String.valueOf(x.getDeadline()));
						textFieldReAdmin.setText(bao2.getacc(x.getSendrequesttoadmin()).getFullname());
						switch (x.getSttrequestleave()) {
						case 0: {
							textFieldStatus.setText("Your request has been rejected");
							break;
						}
						case 1: {
							textFieldStatus.setText("Wait Admin accept");
							break;
						}
						case 2: {
							textFieldStatus.setText("Wait Hr accept");
							break;
						}
						case 3: {
							textFieldStatus.setText("Wait Admin update calendar");
							break;
						}
						case 4: {
							textFieldStatus.setText("Your request has been accepted ");
							break;
						}
						case 5: {
							textFieldStatus.setText("This request has expired ");
							break;
						}
						}
					}

					public void mouseEntered(MouseEvent e) {
						rowPanel.setBackground(Color.GRAY);
					}

					public void mouseExited(MouseEvent e) {
						rowPanel.setBackground(Color.white);
					}
				});

			});
			loadPressed(jPanel);
		}
		if (bao.getRLByIdemp(employee.getIdemp()).size() == 0) {
			jPanel.removeAll();
			jPanel.revalidate();
			JPanel rowPanel = new JPanel();
			rowPanel.setPreferredSize(new Dimension(150, 100));
			jPanel.add(rowPanel);
			rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.Y_AXIS));
			rowPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			rowPanel.setBackground(Color.white);

			JPanel a;
			JPanel b;
			JLabel c;
			JLabel d;

			a = new JPanel();
			a.setOpaque(true);
			a.setBackground(new Color(0, 0, 0, 0));
			rowPanel.add(a);

			a.setLayout(new BorderLayout(0, 0));

			c = new JLabel("No Request");
			a.add(c, BorderLayout.CENTER);

		}
	}

	protected void btnRequestLeaveActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panelMain.getLayout();
		dateChooserFrom.setCalendar(null);
		dateChooserTo.setCalendar(null);
		card.show(panelMain, "request_leave");
	}

	protected void btnBackActionPerformed(ActionEvent e) {
		ChooseType chooseType = new ChooseType(employee);
		this.setVisible(false);
		chooseType.setVisible(true);
	}
}
