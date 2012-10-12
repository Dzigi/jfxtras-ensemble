/*
 * Copyright (c) 2012, JFXtras
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *       * Redistributions of source code must retain the above copyright
 *         notice, this list of conditions and the following disclaimer.
 *       * Redistributions in binary form must reproduce the above copyright
 *         notice, this list of conditions and the following disclaimer in the
 *         documentation and/or other materials provided with the distribution.
 *       * Neither the name of the <organization> nor the
 *         names of its contributors may be used to endorse or promote products
 *         derived from this software without specific prior written permission.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 *   DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package ensemble.samples.controls;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import jfxtras.labs.scene.control.Agenda;
import ensemble.Sample;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.util.Callback;

/**
 * Agenda.
 * The coder is responsible for the background (in this way the picker does not enforce a certain styling).
 *
 * @see jfxtras.labs.scene.control.Agenda
 */
public class AgendaSample1 extends Sample {

    public AgendaSample1() {
        super(600, 600);

        GridPane lGridPane = new GridPane();
        lGridPane.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        getChildren().add(lGridPane);
        int lRowIdx = 0;

        {
	        final Agenda lAgenda = new Agenda();
                lAgenda.setPrefSize(600, 600);
                lAgenda.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
	        lGridPane.add(lAgenda, 0, lRowIdx, 2, 1);
	        lRowIdx++;

		// accept new appointments
		lAgenda.createAppointmentCallbackProperty().set(new Callback<Agenda.CalendarRange, Agenda.Appointment>()
		{
                    public Agenda.Appointment call(Agenda.CalendarRange calendarRange)
                    {
                        return new Agenda.AppointmentImpl()
                        .withStartTime(calendarRange.getStartCalendar())
                        .withEndTime(calendarRange.getEndCalendar())
                        .withSummary("new")
                        .withDescription("new")
                        .withStyleClass("group1");
                    }
		});
		
		// initial set
		Calendar lFirstDayOfWeekCalendar = getFirstDayOfWeekCalendar(lAgenda.getLocale(), lAgenda.getDisplayedCalendar());
		int lYear = lFirstDayOfWeekCalendar.get(Calendar.YEAR);
		int lMonth = lFirstDayOfWeekCalendar.get(Calendar.MONTH);
		int lDay = lFirstDayOfWeekCalendar.get(Calendar.DATE);
		lAgenda.appointments().addAll(
			new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay, 8, 00))
				.withEndTime(new GregorianCalendar(lYear, lMonth, lDay, 11, 30))
				.withSummary("A")
				.withDescription("A much longer test description")
				.withStyleClass("group7")
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay, 8, 30))
				.withEndTime(new GregorianCalendar(lYear, lMonth, lDay, 10, 00))
				.withSummary("B")
				.withDescription("A description 2")
				.withStyleClass("group8")
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay, 8, 30))
				.withEndTime(new GregorianCalendar(lYear, lMonth, lDay, 9, 30))
				.withSummary("C")
				.withDescription("A description 3")
				.withStyleClass("group9")
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay, 9, 00))
				.withEndTime(new GregorianCalendar(lYear, lMonth, lDay, 13, 30))
				.withSummary("D")
				.withDescription("A description 4")
				.withStyleClass("group7")
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay, 10, 30))
				.withEndTime(new GregorianCalendar(lYear, lMonth, lDay, 11, 00))
				.withSummary("E")
				.withDescription("A description 4")
				.withStyleClass("group7")
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay, 12, 30))
				.withEndTime(new GregorianCalendar(lYear, lMonth, lDay, 13, 30))
				.withSummary("F")
				.withDescription("A description 4")
				.withStyleClass("group7")
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay, 13, 00))
				.withEndTime(new GregorianCalendar(lYear, lMonth, lDay, 13, 30))
				.withSummary("H")
				.withDescription("A description 4")
				.withStyleClass("group7")
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay, 14, 00))
				.withEndTime(new GregorianCalendar(lYear, lMonth, lDay, 14, 45))
				.withSummary("G")
				.withDescription("A description 4")
				.withStyleClass("group7")
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay, 15, 00))
				.withEndTime(new GregorianCalendar(lYear, lMonth, lDay, 16, 00))
				.withSummary("I")
				.withDescription("A description 4")
				.withStyleClass("group7")
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay, 15, 30))
				.withEndTime(new GregorianCalendar(lYear, lMonth, lDay, 16, 00))
				.withSummary("J")
				.withDescription("A description 4")
				.withStyleClass("group7")
		// -----
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay))
				.withSummary("all day1")
				.withDescription("A description")
				.withStyleClass("group7")
				.withWholeDay(true)
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay))
				.withSummary("all day2")
				.withDescription("A description")
				.withStyleClass("group8")
				.withWholeDay(true)
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay))
				.withSummary("all day3")
				.withDescription("A description3")
				.withStyleClass("group9")
				.withWholeDay(true)
		, 	new Agenda.AppointmentImpl()
				.withStartTime(new GregorianCalendar(lYear, lMonth, lDay + 1))
				.withSummary("all day")
				.withDescription("A description3")
				.withStyleClass("group3")
				.withWholeDay(true)
		);
		final String lIpsum = "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus";
		// day spanner
		{
			Calendar lStart = (Calendar)lFirstDayOfWeekCalendar.clone();
			lStart.add(Calendar.SECOND, 5);
			lStart.add(Calendar.DATE, 1);
			Calendar lEnd = (Calendar)lStart.clone();
			lEnd.add(Calendar.DATE, 2);
			
			Agenda.Appointment lAppointment = new Agenda.AppointmentImpl()
			.withStartTime(lStart)
			.withEndTime(lEnd)
			.withSummary(lIpsum.substring(0, new Random().nextInt(50)))
			.withDescription(lIpsum.substring(0, 10 + new Random().nextInt(lIpsum.length() - 10)))
			.withStyleClass("group" + (new Random().nextInt(3) + 1));
			
			lAgenda.appointments().add(lAppointment);
		}
		

		// update range
		final AtomicBoolean lSkippedFirstRangeChange = new AtomicBoolean(false);		
		lAgenda.calendarRangeCallbackProperty().set(new Callback<Agenda.CalendarRange, Void>()
		{
			public Void call(Agenda.CalendarRange arg0)
			{
				// the first change should not be processed, because it is set above
				if (lSkippedFirstRangeChange.get() == false)
				{
					lSkippedFirstRangeChange.set(true);
					return null;
				}
				
				// add a whole bunch of random appointments
				for (int i = 0; i < 20; i++)
				{
					Calendar lFirstDayOfWeekCalendar = getFirstDayOfWeekCalendar(lAgenda.getLocale(), lAgenda.getDisplayedCalendar());
					
					Calendar lStart = (Calendar)lFirstDayOfWeekCalendar.clone();
					lStart.add(Calendar.DATE, new Random().nextInt(7));
					lStart.add(Calendar.HOUR_OF_DAY, new Random().nextInt(24));
					lStart.add(Calendar.MINUTE, new Random().nextInt(60));
					
					Calendar lEnd = (Calendar)lStart.clone();
					lEnd.add(Calendar.MINUTE, 15 + new Random().nextInt(24 * 60));
					
					Agenda.Appointment lAppointment = new Agenda.AppointmentImpl()
					.withStartTime(lStart)
					.withEndTime(lEnd)
					.withWholeDay(new Random().nextInt(50) > 40)
					.withSummary(lIpsum.substring(0, new Random().nextInt(50)))
					.withDescription(lIpsum.substring(0, new Random().nextInt(lIpsum.length())))
					.withStyleClass("group" + (new Random().nextInt(24)));					
					lAgenda.appointments().add(lAppointment);
				}
				return null;
			}
		});
                
//	        ComboBox<String> lComboBox = new ComboBox<String>(FXCollections.observableArrayList("Single", "Range", "Multiple"));
//	        lComboBox.valueProperty().addListener(new ChangeListener<String>()
//                {
//                    @Override
//                    public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue)
//                    {
//                            if (newValue.startsWith("S")) lAgenda.setMode(Agenda.Mode.SINGLE);
//                            if (newValue.startsWith("R")) lAgenda.setMode(Agenda.Mode.RANGE);
//                            if (newValue.startsWith("M")) lAgenda.setMode(Agenda.Mode.MULTIPLE);
//                    }
//                });
//	        lComboBox.setValue("Single");
//	        lComboBox.setPrefWidth(200); 
//	        lGridPane.add(new Label("Mode:"), 0, lRowIdx);
//	        lGridPane.add(lComboBox, 1, lRowIdx);
//	        lRowIdx++;
        }
    }

	/**
	 * get the calendar for the first day of the week
	 */
	static private Calendar getFirstDayOfWeekCalendar(Locale locale, Calendar lDisplayedCalendar)
	{
		// result
		Calendar lLocalCalendar = Calendar.getInstance(locale);
		int lFirstDayOfWeek = lLocalCalendar.getFirstDayOfWeek();
		
		// this is the first day of week calendar
		Calendar lFirstDayOfWeekCalendar = (Calendar)lDisplayedCalendar.clone();
		
		// if not on the first day of the week, correct with the appropriate amount
		lFirstDayOfWeekCalendar.add(Calendar.DATE, lFirstDayOfWeek - lFirstDayOfWeekCalendar.get(Calendar.DAY_OF_WEEK));
		
		// make sure we are in the same week
		while ( lFirstDayOfWeekCalendar.get(Calendar.YEAR) > lDisplayedCalendar.get(Calendar.YEAR)
			 || (lFirstDayOfWeekCalendar.get(Calendar.YEAR) == lDisplayedCalendar.get(Calendar.YEAR) && lFirstDayOfWeekCalendar.get(Calendar.WEEK_OF_YEAR) > lDisplayedCalendar.get(Calendar.WEEK_OF_YEAR))
			  )
		{
			lFirstDayOfWeekCalendar.add(Calendar.DATE, -7);
		}
		while ( lFirstDayOfWeekCalendar.get(Calendar.YEAR) < lDisplayedCalendar.get(Calendar.YEAR)
				 || (lFirstDayOfWeekCalendar.get(Calendar.YEAR) == lDisplayedCalendar.get(Calendar.YEAR) && lFirstDayOfWeekCalendar.get(Calendar.WEEK_OF_YEAR) < lDisplayedCalendar.get(Calendar.WEEK_OF_YEAR))
				  )
		{
			lFirstDayOfWeekCalendar.add(Calendar.DATE, 7);
		}
		
		// done
		return lFirstDayOfWeekCalendar;
	}
}
