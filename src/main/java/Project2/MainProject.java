package Project2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
import javax.swing.JTextField;
import java.awt.Color;
//import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MainProject extends JFrame {

	private JPanel contentPane;
	private JTextField Value;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainProject frame = new MainProject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainProject() {
		setForeground(new Color(128, 128, 128));
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton listing = new JButton("LIST OF AIRLINES");
		listing.setBackground(UIManager.getColor("Button.darkShadow"));
		listing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("\n");
				Callback<List<Airline>> callBack = new Callback<List<Airline>>() {
					@Override
					public void onResponse(Call<List<Airline>> call, Response<List<Airline>> response) {
						
						if (response == null) {
							System.out.println("Response is null");
						} else {
						if (!response.isSuccessful() || response.body() == null) {
							System.out.println("Failed: Reason raw data: " + response.raw());
							System.out.println("Failed: Reason errorbody: " + response.errorBody());
						} else {

							List<Airline> al = response.body();
							for (Airline a : al) {
								// System.out.println(response.body());
								String content = "{";
								content += " name: " + a.getName();
								content += ", code: " + a.getCode();
								content += ", imageUrl: " + a.getImageUrl();
								content += ", isAvailable: " + a.getIsAvailabe();
								content += ", dailyFlights: " + a.getDailyFlights();
								content += "},";
								System.out.println(content);
							}

						}
					}}

					@Override
					public void onFailure(Call<List<Airline>> call, Throwable t) {
						t.printStackTrace();
					}

				};
				NetworkingHelper.getInstance().getService().getAirlines().enqueue(callBack);

			}
		});
		listing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listing.setBounds(397, 194, 267, 37);
		contentPane.add(listing);

		JButton btnNewButton = new JButton("SINGLE AIRLINE");
		btnNewButton.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("\n");

				Callback<Airline> callBack = new Callback<Airline>() {
					@Override
					public void onResponse(Call<Airline> call, Response<Airline> response) {
						
						if (response == null) {
							System.out.println("Response is null");
						} else {
						if (!response.isSuccessful() || response.body() == null) {
							System.out.println("Failed: Reason raw data: " + response.raw());
							System.out.println("Failed: Reason errorbody: " + response.errorBody());
						} else {

							System.out.println("{ \n  name: " + response.body().getName());
							System.out.println("  code: " + response.body().getCode());
							System.out.println("  imageUrl: " + response.body().getImageUrl());
							System.out.println("  isAvailable: " + response.body().getIsAvailabe());
							System.out.println("  dailyFlights: " + response.body().getDailyFlights());
							System.out.println("}");

						}
					}
					}
					@Override
					public void onFailure(Call<Airline> call, Throwable t) {
						System.out.println("map reposne failed: reason: " + t.getMessage());
					}

				};
				NetworkingHelper.getInstance().getService().singleAirline().enqueue(callBack);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(397, 124, 267, 37);
		contentPane.add(btnNewButton);

		JCheckBox checkBox = new JCheckBox("SHUFFLE?");
		checkBox.setBackground(new Color(176, 196, 222));
		checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox.setBounds(565, 291, 102, 37);
		contentPane.add(checkBox);

		JButton btnNewButton_1 = new JButton("LIMIT");
		btnNewButton_1.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = Value.getText();

				if (checkBox.isSelected()) {
					System.out.println("\n");

					Callback<List<Airline>> callBack = new Callback<List<Airline>>() {
						@Override
						public void onResponse(Call<List<Airline>> call, Response<List<Airline>> response) {

							if (response == null) {
								System.out.println("Response is null");
							} else {
								if (!response.isSuccessful() || response.body() == null) {

									System.out.println("Failed: Reason raw data: " + response.raw());
									System.out.println("Failed: Reason errorbody: " + response.errorBody());
								} else {

									List<Airline> al = response.body();
									for (Airline a : al) {
										// System.out.println(response.body());
										String content = "{";
										content += " name: " + a.getName();
										content += ", code: " + a.getCode();
										content += ", imageUrl: " + a.getImageUrl();
										content += ", isAvailable: " + a.getIsAvailabe();
										content += ", dailyFlights: " + a.getDailyFlights();
										content += "},";
										System.out.println(content);
									}

								}
							}
						}

						@Override
						public void onFailure(Call<List<Airline>> call, Throwable t) {
							System.out.println("map reposne failed: reason: " + t.getMessage());
						}

					};
					NetworkingHelper.getInstance().getService().limitAirlinesShuffle(val, true).enqueue(callBack);

				} else {
					System.out.println("\n");

					Callback<List<Airline>> callBack = new Callback<List<Airline>>() {
						@Override
						public void onResponse(Call<List<Airline>> call, Response<List<Airline>> response) {
							
							if (response == null) {
								System.out.println("Response is null");
							} else {
							if (!response.isSuccessful() || response.body() == null) {
								System.out.println("Failed: Reason raw data: " + response.raw());
								System.out.println("Failed: Reason errorbody: " + response.errorBody());
							} else {

								List<Airline> al = response.body();
								for (Airline a : al) {
									// System.out.println(response.body());
									String content = "{";
									content += " name: " + a.getName();
									content += ", code: " + a.getCode();
									content += ", imageUrl: " + a.getImageUrl();
									content += ", isAvailable: " + a.getIsAvailabe();
									content += ", dailyFlights: " + a.getDailyFlights();
									content += "},";
									System.out.println(content);
								}

							}
						}
						}
						@Override
						public void onFailure(Call<List<Airline>> call, Throwable t) {
							System.out.println("map reposne failed: reason: " + t.getMessage());
						}

					};
					NetworkingHelper.getInstance().getService().limitAirlines(val).enqueue(callBack);

				}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(401, 289, 145, 37);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("SEARCH AIRLINE");
		btnNewButton_2.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = Value.getText();
				System.out.println("\n");

				Callback<Airline> callBack = new Callback<Airline>() {
					@Override
					public void onResponse(Call<Airline> call, Response<Airline> response) {
						
						if (response == null) {
							System.out.println("Response is null");
						} else {
						if (!response.isSuccessful() || response.body() == null) {
							System.out.println("Failed: Reason raw data: " + response.raw());
							System.out.println("Failed: Reason errorbody: " + response.errorBody());
						} else {

							System.out.println("{ \n  name: " + response.body().getName());
							System.out.println("  code: " + response.body().getCode());
							System.out.println("  imageUrl: " + response.body().getImageUrl());
							System.out.println("  isAvailable: " + response.body().getIsAvailabe());
							System.out.println("  dailyFlights: " + response.body().getDailyFlights());
							System.out.println("}");

						}
					}
					}
					@Override
					public void onFailure(Call<Airline> call, Throwable t) {
						System.out.println("map reposne failed: reason: " + t.getMessage());
					}

				};
				NetworkingHelper.getInstance().getService().searchAirline(val).enqueue(callBack);

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(408, 378, 267, 37);
		contentPane.add(btnNewButton_2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(0, -2, 735, 58);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("WORK SPACE");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(250, 235, 215));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 31));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(0, 55, 365, 496);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("VALUE:");
		lblNewLabel_2.setBounds(45, 175, 91, 43);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));

		Value = new JTextField();
		Value.setBounds(45, 240, 168, 43);
		panel_1.add(Value);
		Value.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Value.setColumns(10);

		JButton btnNewButton_3 = new JButton("OBJECTS");
		btnNewButton_3.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = Value.getText();

				System.out.println("\n");

				Callback<AirlineObjectResponse> callBack = new Callback<AirlineObjectResponse>() {
					@Override
					public void onResponse(Call<AirlineObjectResponse> call, Response<AirlineObjectResponse> response) {
						
						if (response == null) {
							System.out.println("Response is null");
						} else {
						if (!response.isSuccessful() || response.body() == null) {
							System.out.println("Failed: Reason raw data: " + response.raw());
							System.out.println("Failed: Reason errorbody: " + response.errorBody());
						} else {

							List<Airline> ali = response.body().dataArray;
							System.out.println("[");
							for (Airline a : ali) {
								String content = " {";
								content += " name : " + a.getName() + "\n";
								content += "   code : " + a.getCode() + "\n },";

								System.out.println(content);

							}
							System.out.println("]");

						}
					}}

					@Override
					public void onFailure(Call<AirlineObjectResponse> call, Throwable t) {
						System.out.println("map reposne failed: reason: " + t.getMessage());
					}

				};
				NetworkingHelper.getInstance().getService().objectAirlines(val).enqueue(callBack);

			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_3.setBounds(393, 457, 134, 43);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("MAP");
		btnNewButton_4.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String val = Value.getText();

				System.out.println("\n");
//						

				Callback<AirlineMapResponse> callback = new Callback<AirlineMapResponse>() {

					@Override
					public void onResponse(Call<Project2.AirlineMapResponse> call,
							Response<Project2.AirlineMapResponse> response) {
						
						if (response == null) {
							System.out.println("Response is null");
						} else {
						if (!response.isSuccessful() || response.body() == null) {
							System.out.println("map reposne failed: reason raw: " + response.raw());
							System.out.println("map reposne failed: reason errBody: " + response.errorBody());
						} else {

							HashMap<String, Airline> responseMap = response.body().dataMap;

							Set<String> keys = responseMap.keySet();

							Iterator<String> iter = keys.iterator();

							while (iter.hasNext()) {
								String key = iter.next();

								Airline value = responseMap.get(key);

								System.out.println("key: " + key + " value: " + value.name);
							}

						}
						}
						// TODO Auto-generated method stub
						// System.out.println(response.body());

					}

					@Override
					public void onFailure(Call<Project2.AirlineMapResponse> call, Throwable t) {
						System.out.println("map reposne failed: reason: " + t.getMessage());

					}
				};

				NetworkingHelper.getInstance().getService().mapAirlines(val).enqueue(callback);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_4.setBounds(550, 457, 145, 43);
		contentPane.add(btnNewButton_4);

	}
}
