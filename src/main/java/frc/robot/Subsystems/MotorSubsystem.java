// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
	/** Creates a new MotorSubsystem. */
	private final SparkMax m_SparkMaxOne = new SparkMax(1, MotorType.kBrushless);
	private final RelativeEncoder m_encoder = m_SparkMaxOne.getEncoder();

	public MotorSubsystem() {
		SparkMaxConfig config = new SparkMaxConfig();
		config.inverted(false).idleMode(IdleMode.kBrake);
		m_SparkMaxOne.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
	}

	/**
	 * Sets the speed of the intake motor.
	 * 
	 * @param speed The speed.
	 */
	public void setSpeed(double speed) {
		m_SparkMaxOne.set(speed);
	}

	/**
	 * Creates a command to reverse the intake.
	 * 
	 * @return The command.
	 */
	public Command reverseIntakeCommand() {
		return runOnce(() -> setSpeed(-1));
	}

	/**
	 * Creates a command to spin the intake forward.
	 * 
	 * @return The command.
	 */
	public Command forwardIntakeCommand() {
		return runOnce(() -> setSpeed(1));
	}

	/**
	 * Creates a command to stop the intake.
	 * 
	 * @return The command.
	 */
	public Command stopIntakeCommand() {
		return runOnce(() -> setSpeed(0));
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}