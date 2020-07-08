/*
    A benchmark for runtime monitors
    Copyright (C) 2020 Laboratoire d'informatique formelle

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package monitorlab.source.converter;

import ca.uqac.lif.json.JsonElement;
import ca.uqac.lif.json.JsonParser;
import ca.uqac.lif.json.JsonParser.JsonParseException;
import monitorlab.source.LineConverter;
import monitorlab.source.SourceException;

/**
 * Converts a line of JSON markup into a {@link JsonElement}.
 */
public class StringToJson implements LineConverter<JsonElement>
{
	/**
	 * The parser used to create JSON elements.
	 */
	protected static final transient JsonParser s_parser = new JsonParser();
	
	/**
	 * Reference to a single public instance of the converter.
	 */
	public static final transient StringToJson instance = new StringToJson();
	
	/**
	 * Creates a new instance of the converter
	 */
	protected StringToJson()
	{
		super();
	}
	
	@Override
	public JsonElement getEvent(String line) throws SourceException
	{
		try
		{
			return s_parser.parse(line);
		}
		catch (JsonParseException e)
		{
			throw new SourceException(e);
		}
	}

}
