package com.adero.thing;

import com.thingworx.logging.LogUtilities;
import com.thingworx.metadata.annotations.ThingworxBaseTemplateDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceParameter;
import com.thingworx.metadata.annotations.ThingworxServiceResult;
import com.thingworx.things.Thing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;

@ThingworxBaseTemplateDefinition(name = "GenericThing")
public class VegetationIndices extends Thing {

	private static Logger _logger = LogUtilities.getInstance().getApplicationLogger(VegetationIndices.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VegetationIndices() {
		// TODO Auto-generated constructor stub
	}
	//Start Methods
	public static float NDVI(float r, float b)
	{
		float ndvi;
	    float num = r-b;
	    float denom = r+b;
        if (denom != 0.0F) {
            ndvi = num / denom;
        } else {
            ndvi = 0.0F;
        }

        if (ndvi < 0.0F) {
            ndvi = 0.0F;
        } else if (ndvi > 1.0F) {
            ndvi = 1.0F;
        }
		return ndvi;
	}
	public static float SR(float r, float b)
	{
		float sr;
		sr = r/b;
		return sr;
	}
	public static float MSR(float r, float b)
	{
		float msr;
		msr = (float) (((r/b)-1)/((Math.pow((r/b),(1/2)))+1));
		return msr;
	}
	public static float DVI(float r, float b)
	{
		float dvi;
		dvi = r-b;
		return dvi;
	}
	public static float GNDVI(float r, float g, float b)
	{
		float gndvi;
		gndvi = (r-g)/(r+g);
		return gndvi;
	}
	public static float RDVI(float r, float b)
	{
		float rdvi;
		rdvi = (float) ((r-b)/Math.sqrt((r+b)));
		return rdvi;
	}
	public static float IPVI(float r, float b)
	{
		float sr;
		sr = r/(r+b);
		return sr;
	}
	public static float SAVI(float r, float b)
	{
		float savi;
		float L=(float) 0.5;
		savi = ((1+L)*(r-b))/(r+b+L);
		return savi;
	}
	public static float OSAVI(float r, float b)
	{
		float sr;
		sr = (float) ((r-b)/(r+b+0.16));
		return sr;
	}
	public static float MSAVI(float r, float b)
	{
		float msavi;
		float t1 = ((2*r)+1)-(8*(r-b));
		float t2 = (float) ((2*r)+1-(Math.sqrt(t1)));
		msavi = 1/2*t2;
		return msavi;
	}
	public static float NLI(float r, float b)
	{
		float NLI;
		NLI = (float) ((Math.pow(r, 2)-b)/(Math.pow(r, 2)+b));
		return NLI;
	}
	public static float TVI(float r, float g, float b)
	{
		float tvi;
		tvi = (float) (0.5*((120*(r-g))-(200*(b-g))));
		return tvi;
	}
	public static float MTVI1(float r, float g, float b)
	{
		float mtvi1;
		mtvi1 = (float) (1.2*((1.2*(r-g))-(2.5*(b-g))));
		return mtvi1;
	}
	public static float MTVI2(float r, float g, float b)
	{
		float mtvi2;
		float t1 = (float) Math.sqrt(Math.pow((2*r+1), 2)-((6*r)-(5*Math.sqrt(b))-0.5));
		float t2 = (float) (1.2*((1.2*(r-g))-(2.5*(b-g))));
		mtvi2 = t1/t2;
		return mtvi2;
	}
	public static float NDGI(float r, float g, float b)
	{
		float ndgi;
		ndgi = (g-r)/(g+r);
		return ndgi;
	}
	public static float RVI(float r, float b)
	{
		float rvi;
		rvi = b/r;
		return rvi;
	}
	public static float VIN(float r, float b)
	{
		float VIN;
		VIN = r/b;
		return VIN;
	}

	public static int toRGB(int[] i) {
		int rgb = 0;
		rgb += (i[0] << 16);
		rgb += (i[1] << 8);
		rgb += i[2];
		return rgb;
	}
	
	public static int NDVIColor(float i) {
		int r = 0;
		int g = 0;
		int b = 0;
		if(i==0)
		{
			r=0;
			g=0;
			b=0;
	    }
		if(i>=0 && i<=1)
		{
			r=51;
			g=0;
			b=51;
		}
		else if(i>=1 && i<=2)
		{
			r=102;
			g=0;
			b=102;
		}
		else if(i>=2 && i<=3)
		{
			r=204;
			g=0;
			b=204;
		}
		else if(i>=3 && i<=4)
		{
			r=76;
			g=0;
			b=153;
		}
		else if(i>=4 && i<=5)
		{
			r=0;
			g=0;
			b=102;
		}
		else if(i>=6 && i<=10)
		{
			r=0;
			g=0;
			b=153;
		}
		else if(i>=11 && i<=15)
		{
			r=0;
			g=0;
			b=204;
		}
		else if(i>=16 && i<=20)
		{
			r=0;
			g=102;
			b=102;
		}
		else if(i>=21 && i<=25)
		{
			r=0;
			g=204;
			b=204;
		}
		else if(i>=26 && i<=30)
		{
			r=153;
			g=255;
			b=204;
		}
		else if(i>=31 && i<=35)
		{
			r=51;
			g=255;
			b=51;
		}
		else if(i>=36 && i<=40)
		{
			r=178;
			g=255;
			b=102;
		}
		else if(i>=41 && i<=45)
		{
			r=153;
			g=255;
			b=51;
		}
		else if(i>=46 && i<=50)
		{
			r=204;
			g=255;
			b=153;
		}
		else if(i>=51 && i<=55)
		{
			r=255;
			g=255;
			b=102;
		}
		else if(i>=56 && i<=60)
		{
			r=102;
			g=102;
			b=0;
		}
		else if(i>=61 && i<=65)
		{
			r=255;
			g=0;
			b=0;
		}
		else if(i>=66 && i<=255)
		{
			r=255;
			g=102;
			b=102;
		}
		

		return toRGB(new int[] { r, g, b });
	}
	
	
	
	//End Methods

	@ThingworxServiceDefinition(name = "Ndvi", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultNdvi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] Ndvi(
			@ThingworxServiceParameter(name = "ImgNdvi", description = "", baseType = "IMAGE") byte[] ImgNdvi) {
		_logger.trace("Entering Service: Ndvi");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgNdvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
		    float num = r-b;
		    float denom = r+b;
		    
		    float ndvi;
		//    ndvi = basec[0];


            if (denom != 0.0F) {
                ndvi = num / denom;
            } else {
                ndvi = 0.0F;
            }

            if (ndvi < 0.0F) {
                ndvi = 0.0F;
            } else if (ndvi > 1.0F) {
                ndvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*ndvi);
		    map.setRGB(x, y, NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		_logger.trace("Exiting Service: Ndvi");
		return result;
	}

	@ThingworxServiceDefinition(name = "SR", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultSr", description = "", baseType = "IMAGE", aspects = {})
	public byte[] SR(@ThingworxServiceParameter(name = "ImgSr", description = "", baseType = "IMAGE") byte[] ImgSr) {
		_logger.trace("Entering Service: SR");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgSr);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g= basec[1];
		    float b = basec[2];
		    
		    
			float sr;
			sr = r/b;
		//    ndvi = basec[0];

            if (sr < 0.0F) {
            	sr = 0.0F;
            } else if (sr > 1.0F) {
            	sr = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*sr);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: SR");
		return result;
	}

	@ThingworxServiceDefinition(name = "MSR", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultMsr", description = "", baseType = "IMAGE", aspects = {})
	public byte[] MSR(@ThingworxServiceParameter(name = "ImgMsr", description = "", baseType = "IMAGE") byte[] ImgMsr) {
		_logger.trace("Entering Service: MSR");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgMsr);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g= basec[1];
		    float b = basec[2];
		    
			float msr;
			msr = (float) (((r/b)-1)/((Math.pow((r/b),(1/2)))+1));
			
            if (msr < 0.0F) {
            	msr = 0.0F;
            } else if (msr > 1.0F) {
            	msr = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*msr);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: MSR");
		return result;
	}

	@ThingworxServiceDefinition(name = "DVI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultDvi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] DVI(@ThingworxServiceParameter(name = "ImgDvi", description = "", baseType = "IMAGE") byte[] ImgDvi) {
		_logger.trace("Entering Service: DVI");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgDvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float dvi;
			dvi = r-b;

            if (dvi < 0.0F) {
                dvi = 0.0F;
            } else if (dvi > 1.0F) {
                dvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*dvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: DVI");
		return result;
	}

	@ThingworxServiceDefinition(name = "GNDVI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultGndvi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] GNDVI(
			@ThingworxServiceParameter(name = "ImgGndvi", description = "", baseType = "IMAGE") byte[] ImgGndvi) {
		_logger.trace("Entering Service: GNDVI");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgGndvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float gndvi;
			gndvi = (r-g)/(r+g);

            if (gndvi < 0.0F) {
            	gndvi = 0.0F;
            } else if (gndvi > 1.0F) {
            	gndvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*gndvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: GNDVI");
		return result;
	}

	@ThingworxServiceDefinition(name = "RDVI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultRdvi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] RDVI(
			@ThingworxServiceParameter(name = "ImgRdvi", description = "", baseType = "IMAGE") byte[] ImgRdvi) {
		_logger.trace("Entering Service: RDVI");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgRdvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
			float rdvi;
			rdvi = (float) ((r-b)/Math.sqrt((r+b)));
            if (rdvi < 0.0F) {
            	rdvi = 0.0F;
            } else if (rdvi > 1.0F) {
            	rdvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*rdvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: RDVI");
		return result;
	}

	@ThingworxServiceDefinition(name = "IPVI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultIpvi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] IPVI(
			@ThingworxServiceParameter(name = "ImgIpvi", description = "", baseType = "IMAGE") byte[] ImgIpvi) {
		_logger.trace("Entering Service: IPVI");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgIpvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
			float ipvi;
			ipvi = r/(r+b);

            if (ipvi < 0.0F) {
            	ipvi = 0.0F;
            } else if (ipvi > 1.0F) {
            	ipvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*ipvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: IPVI");
		return result;
	}

	@ThingworxServiceDefinition(name = "SAVI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultSavi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] SAVI(
			@ThingworxServiceParameter(name = "ImgSavi", description = "", baseType = "IMAGE") byte[] ImgSavi) {
		_logger.trace("Entering Service: SAVI");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgSavi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
			float savi;
			float L=(float) 0.5;
			savi = ((1+L)*(r-b))/(r+b+L);

            if (savi < 0.0F) {
            	savi = 0.0F;
            } else if (savi > 1.0F) {
            	savi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*savi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: SAVI");
		return result;
	}

	@ThingworxServiceDefinition(name = "OSAVI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultOsavi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] OSAVI(
			@ThingworxServiceParameter(name = "ImgOsavi", description = "", baseType = "IMAGE") byte[] ImgOsavi) {
		_logger.trace("Entering Service: OSAVI");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgOsavi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float osavi;
			osavi = (float) ((r-b)/(r+b+0.16));

            if (osavi < 0.0F) {
            	osavi = 0.0F;
            } else if (osavi > 1.0F) {
            	osavi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*osavi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: OSAVI");
		return result;
	}

	@ThingworxServiceDefinition(name = "NLI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultNli", description = "", baseType = "IMAGE", aspects = {})
	public byte[] NLI(@ThingworxServiceParameter(name = "ImgNli", description = "", baseType = "IMAGE") byte[] ImgNli) {
		_logger.trace("Entering Service: NLI");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgNli);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float NLI;
			NLI = (float) ((Math.pow(r, 2)-b)/(Math.pow(r, 2)+b));
            if (NLI < 0.0F) {
            	NLI = 0.0F;
            } else if (NLI > 1.0F) {
            	NLI = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*NLI);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: NLI");
		return result;
	}

	@ThingworxServiceDefinition(name = "TVI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultTvi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] TVI(@ThingworxServiceParameter(name = "ImgTvi", description = "", baseType = "IMAGE") byte[] ImgTvi) {
		_logger.trace("Entering Service: TVI");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgTvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float tvi;
			tvi = (float) (0.5*((120*(r-g))-(200*(b-g))));

            if (tvi < 0.0F) {
            	tvi = 0.0F;
            } else if (tvi > 1.0F) {
            	tvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*tvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: TVI");
		return result;
	}

	@ThingworxServiceDefinition(name = "MTVI1", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultMtvi1", description = "", baseType = "IMAGE", aspects = {})
	public byte[] MTVI1(
			@ThingworxServiceParameter(name = "imgMtvi1", description = "", baseType = "IMAGE") byte[] imgMtvi1) {
		_logger.trace("Entering Service: MTVI1");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(imgMtvi1);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float mtvi1;
			mtvi1 = (float) (1.2*((1.2*(r-g))-(2.5*(b-g))));

            if (mtvi1 < 0.0F) {
            	mtvi1 = 0.0F;
            } else if (mtvi1 > 1.0F) {
            	mtvi1 = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*mtvi1);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: MTVI1");
		return result;
	}

	@ThingworxServiceDefinition(name = "MTVI2", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultMtvi2", description = "", baseType = "IMAGE", aspects = {})
	public byte[] MTVI2(
			@ThingworxServiceParameter(name = "ImgMtvi2", description = "", baseType = "IMAGE") byte[] ImgMtvi2) {
		_logger.trace("Entering Service: MTVI2");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgMtvi2);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float mtvi2;
			float t1 = (float) Math.sqrt(Math.pow((2*r+1), 2)-((6*r)-(5*Math.sqrt(b))-0.5));
			float t2 = (float) (1.2*((1.2*(r-g))-(2.5*(b-g))));
			mtvi2 = t1/t2;

            if (mtvi2 < 0.0F) {
            	mtvi2 = 0.0F;
            } else if (mtvi2 > 1.0F) {
            	mtvi2 = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*mtvi2);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: MTVI2");
		return result;
	}

	@ThingworxServiceDefinition(name = "NDGI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultNdgi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] NDGI(
			@ThingworxServiceParameter(name = "ImgNdgi", description = "", baseType = "IMAGE") byte[] ImgNdgi) {
		_logger.trace("Entering Service: NDGI");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgNdgi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float ndgi;
			ndgi = (g-r)/(g+r);

            if (ndgi < 0.0F) {
            	ndgi = 0.0F;
            } else if (ndgi > 1.0F) {
            	ndgi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*ndgi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: NDGI");
		return result;
	}

	@ThingworxServiceDefinition(name = "RVI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultRvi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] RVI(@ThingworxServiceParameter(name = "ImgRvi", description = "", baseType = "IMAGE") byte[] ImgRvi) {
		_logger.trace("Entering Service: RVI");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgRvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float rvi;
			rvi = b/r;

            if (rvi < 0.0F) {
            	rvi = 0.0F;
            } else if (rvi > 1.0F) {
            	rvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*rvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: RVI");
		return result;
	}

	@ThingworxServiceDefinition(name = "VIN", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultVin", description = "", baseType = "IMAGE", aspects = {})
	public byte[] VIN(@ThingworxServiceParameter(name = "ImgVin", description = "", baseType = "IMAGE") byte[] ImgVin) {
		_logger.trace("Entering Service: VIN");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgVin);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float VIN;
			VIN = r/b;

            if (VIN < 0.0F) {
            	VIN = 0.0F;
            } else if (VIN > 1.0F) {
            	VIN = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*VIN);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: VIN");
		return result;
	}
	@ThingworxServiceDefinition(name = "MSAVI", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultMsavi", description = "", baseType = "IMAGE", aspects = {})
	public byte[] MSAVI(
			@ThingworxServiceParameter(name = "ImgMsavi", description = "", baseType = "IMAGE") byte[] ImgMsavi) {
		_logger.trace("Entering Service: MSAVI");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgMsavi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
			float msavi;
			float t1 = ((2*r)+1)-(8*(r-b));
			float t2 = (float) ((2*r)+1-(Math.sqrt(t1)));
			msavi = 1/2*t2;

            if (msavi < 0.0F) {
            	msavi = 0.0F;
            } else if (msavi > 1.0F) {
            	msavi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*msavi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		_logger.trace("Exiting Service: MSAVI");
		return null;
	}
	
	//Start Grey
	

	@ThingworxServiceDefinition(name = "NDVI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultNdvi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] NDVI_Grey(
			@ThingworxServiceParameter(name = "ImgNdvi_Grey", description = "", baseType = "IMAGE") byte[] ImgNdvi) {
		_logger.trace("Entering Service: Ndvi_Grey");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgNdvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
		    float num = r-b;
		    float denom = r+b;
		    
		    float ndvi;
		//    ndvi = basec[0];


            if (denom != 0.0F) {
                ndvi = num / denom;
            } else {
                ndvi = 0.0F;
            }

            if (ndvi < 0.0F) {
                ndvi = 0.0F;
            } else if (ndvi > 1.0F) {
                ndvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*ndvi);
		    map.setRGB(x, y, NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		_logger.trace("Exiting Service: Ndvi_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "SR_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultSr_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] SR_Grey(@ThingworxServiceParameter(name = "ImgSr_Grey", description = "", baseType = "IMAGE") byte[] ImgSr) {
		_logger.trace("Entering Service: SR_Grey");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgSr);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g= basec[1];
		    float b = basec[2];
		    
		    
			float sr;
			sr = r/b;
		//    ndvi = basec[0];

            if (sr < 0.0F) {
            	sr = 0.0F;
            } else if (sr > 1.0F) {
            	sr = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*sr);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: SR_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "MSR_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultMsr_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] MSR_Grey(@ThingworxServiceParameter(name = "ImgMsr_Grey", description = "", baseType = "IMAGE") byte[] ImgMsr) {
		_logger.trace("Entering Service: MSR_Grey");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgMsr);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g= basec[1];
		    float b = basec[2];
		    
			float msr;
			msr = (float) (((r/b)-1)/((Math.pow((r/b),(1/2)))+1));
			
            if (msr < 0.0F) {
            	msr = 0.0F;
            } else if (msr > 1.0F) {
            	msr = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*msr);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: MSR_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "DVI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultDvi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] DVI_Grey(@ThingworxServiceParameter(name = "ImgDvi_Grey", description = "", baseType = "IMAGE") byte[] ImgDvi) {
		_logger.trace("Entering Service: DVI_Grey");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgDvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float dvi;
			dvi = r-b;

            if (dvi < 0.0F) {
                dvi = 0.0F;
            } else if (dvi > 1.0F) {
                dvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*dvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: DVI_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "GNDVI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultGndvi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] GNDVI_Grey(
			@ThingworxServiceParameter(name = "ImgGndvi_Grey", description = "", baseType = "IMAGE") byte[] ImgGndvi) {
		_logger.trace("Entering Service: GNDVI_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgGndvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float gndvi;
			gndvi = (r-g)/(r+g);

            if (gndvi < 0.0F) {
            	gndvi = 0.0F;
            } else if (gndvi > 1.0F) {
            	gndvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*gndvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: GNDVI_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "RDVI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultRdvi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] RDVI_Grey(
			@ThingworxServiceParameter(name = "ImgRdvi_Grey", description = "", baseType = "IMAGE") byte[] ImgRdvi) {
		_logger.trace("Entering Service: RDVI_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgRdvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
			float rdvi;
			rdvi = (float) ((r-b)/Math.sqrt((r+b)));
            if (rdvi < 0.0F) {
            	rdvi = 0.0F;
            } else if (rdvi > 1.0F) {
            	rdvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*rdvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: RDVI_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "IPVI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultIpvi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] IPVI_Grey(
			@ThingworxServiceParameter(name = "ImgIpvi_Grey", description = "", baseType = "IMAGE") byte[] ImgIpvi) {
		_logger.trace("Entering Service: IPVI_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgIpvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
			float ipvi;
			ipvi = r/(r+b);

            if (ipvi < 0.0F) {
            	ipvi = 0.0F;
            } else if (ipvi > 1.0F) {
            	ipvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*ipvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: IPVI_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "SAVI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultSavi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] SAVI_Grey(
			@ThingworxServiceParameter(name = "ImgSavi_Grey", description = "", baseType = "IMAGE") byte[] ImgSavi) {
		_logger.trace("Entering Service: SAVI_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgSavi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
			float savi;
			float L=(float) 0.5;
			savi = ((1+L)*(r-b))/(r+b+L);

            if (savi < 0.0F) {
            	savi = 0.0F;
            } else if (savi > 1.0F) {
            	savi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*savi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: SAVI_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "OSAVI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultOsavi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] OSAVI_Grey(
			@ThingworxServiceParameter(name = "ImgOsavi_Grey", description = "", baseType = "IMAGE") byte[] ImgOsavi) {
		_logger.trace("Entering Service: OSAVI_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgOsavi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float osavi;
			osavi = (float) ((r-b)/(r+b+0.16));

            if (osavi < 0.0F) {
            	osavi = 0.0F;
            } else if (osavi > 1.0F) {
            	osavi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*osavi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: OSAVI_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "NLI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultNli_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] NLI_Grey(@ThingworxServiceParameter(name = "ImgNli_Grey", description = "", baseType = "IMAGE") byte[] ImgNli) {
		_logger.trace("Entering Service: NLI_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgNli);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float NLI;
			NLI = (float) ((Math.pow(r, 2)-b)/(Math.pow(r, 2)+b));
            if (NLI < 0.0F) {
            	NLI = 0.0F;
            } else if (NLI > 1.0F) {
            	NLI = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*NLI);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: NLI_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "TVI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultTvi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] TVI_Grey(@ThingworxServiceParameter(name = "ImgTvi_Grey", description = "", baseType = "IMAGE") byte[] ImgTvi) {
		_logger.trace("Entering Service: TVI_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgTvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float tvi;
			tvi = (float) (0.5*((120*(r-g))-(200*(b-g))));

            if (tvi < 0.0F) {
            	tvi = 0.0F;
            } else if (tvi > 1.0F) {
            	tvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*tvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: TVI_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "MTVI1_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultMtvi1_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] MTVI1_Grey(
			@ThingworxServiceParameter(name = "imgMtvi1_Grey", description = "", baseType = "IMAGE") byte[] imgMtvi1) {
		_logger.trace("Entering Service: MTVI1_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(imgMtvi1);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float mtvi1;
			mtvi1 = (float) (1.2*((1.2*(r-g))-(2.5*(b-g))));

            if (mtvi1 < 0.0F) {
            	mtvi1 = 0.0F;
            } else if (mtvi1 > 1.0F) {
            	mtvi1 = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*mtvi1);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: MTVI1_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "MTVI2_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultMtvi2_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] MTVI2_Grey(
			@ThingworxServiceParameter(name = "ImgMtvi2_Grey", description = "", baseType = "IMAGE") byte[] ImgMtvi2) {
		_logger.trace("Entering Service: MTVI2_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgMtvi2);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float mtvi2;
			float t1 = (float) Math.sqrt(Math.pow((2*r+1), 2)-((6*r)-(5*Math.sqrt(b))-0.5));
			float t2 = (float) (1.2*((1.2*(r-g))-(2.5*(b-g))));
			mtvi2 = t1/t2;

            if (mtvi2 < 0.0F) {
            	mtvi2 = 0.0F;
            } else if (mtvi2 > 1.0F) {
            	mtvi2 = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*mtvi2);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: MTVI2_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "NDGI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultNdgi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] NDGI_Grey(
			@ThingworxServiceParameter(name = "ImgNdgi_Grey", description = "", baseType = "IMAGE") byte[] ImgNdgi) {
		_logger.trace("Entering Service: NDGI_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgNdgi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float ndgi;
			ndgi = (g-r)/(g+r);

            if (ndgi < 0.0F) {
            	ndgi = 0.0F;
            } else if (ndgi > 1.0F) {
            	ndgi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*ndgi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: NDGI_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "RVI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultRvi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] RVI_Grey(@ThingworxServiceParameter(name = "ImgRvi_Grey", description = "", baseType = "IMAGE") byte[] ImgRvi) {
		_logger.trace("Entering Service: RVI_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgRvi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float rvi;
			rvi = b/r;

            if (rvi < 0.0F) {
            	rvi = 0.0F;
            } else if (rvi > 1.0F) {
            	rvi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*rvi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: RVI_Grey");
		return result;
	}

	@ThingworxServiceDefinition(name = "VIN_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultVin_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] VIN_Grey(@ThingworxServiceParameter(name = "ImgVin_Grey", description = "", baseType = "IMAGE") byte[] ImgVin) {
		_logger.trace("Entering Service: VIN_Grey");
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgVin);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
		    
			float VIN;
			VIN = r/b;

            if (VIN < 0.0F) {
            	VIN = 0.0F;
            } else if (VIN > 1.0F) {
            	VIN = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*VIN);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_logger.trace("Exiting Service: VIN_Grey");
		return result;
	}
	@ThingworxServiceDefinition(name = "MSAVI_Grey", description = "", category = "", isAllowOverride = false, aspects = {
			"isAsync:false" })
	@ThingworxServiceResult(name = "ResultMsavi_Grey", description = "", baseType = "IMAGE", aspects = {})
	public byte[] MSAVI_Grey(
			@ThingworxServiceParameter(name = "ImgMsavi_Grey", description = "", baseType = "IMAGE") byte[] ImgMsavi) {
		_logger.trace("Entering Service: MSAVI_Grey");
		
		
		BufferedImage map = null;
		InputStream in = new ByteArrayInputStream(ImgMsavi);
        try {
			map = ImageIO.read(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] result;
		
	
		
        for (int y = 0; y < map.getHeight(); y++)
		{
			for (int x = 0; x < map.getWidth(); x++)
			{
		
		    Color c = new Color(map.getRGB(x, y));
		    float[] basec = c.getRGBColorComponents(null);
		    //int r = c.getr();
		    //int g = c.getg();
		    //int b = c.getb();
		    
		    float r = basec[0];
		    float g = basec[1];
		    float b = basec[2];
		    
			float msavi;
			float t1 = ((2*r)+1)-(8*(r-b));
			float t2 = (float) ((2*r)+1-(Math.sqrt(t1)));
			msavi = 1/2*t2;

            if (msavi < 0.0F) {
            	msavi = 0.0F;
            } else if (msavi > 1.0F) {
            	msavi = 1.0F;
            }

		    
		    int ndvibyte = (int) (255*msavi);
		    map.setRGB(x, y,  NDVIColor(ndvibyte));
//		    mapArray[x][y] = ndvibyte;	
//		    try {
//				outputStream.writeByte(ndvibyte);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		    
		    

			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(map, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = baos.toByteArray();
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		_logger.trace("Exiting Service: MSAVI_Grey");
		return null;
	}
	
	//End Grey

}
